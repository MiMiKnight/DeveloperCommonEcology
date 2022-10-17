package cn.yhm.developer.ecology.rest.controller;

import cn.yhm.developer.ecology.model.request.GatewayRequest;
import cn.yhm.developer.ecology.model.response.GatewayResponse;
import cn.yhm.developer.ecology.rest.handler.GatewayHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;

/**
 * 网关控制器
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-09-05 01:15:27
 */
@Slf4j
public abstract class GatewayController {

    private interface ExceptionMessage {
        String MSG_001 = "The handlerClass can not be null.";
        String MSG_002 = "'{}' not managed by spring,add @Componet annotation on this Java Class please.";
    }

    @Resource
    private ApplicationContext appContext;

    /**
     * 处理方法
     *
     * @param request      请求
     * @param handlerClass 处理程序类
     * @return response 响应
     * @throws Exception 异常
     */
    public <T extends GatewayResponse, R extends GatewayRequest, H extends GatewayHandler<R, T>> T handle(R request,
                                                                                                          Class<H> handlerClass) throws Exception {
        if (handlerClass == null) {
            throw new IllegalArgumentException(ExceptionMessage.MSG_001);
        }
        H handler;
        try {
            handler = appContext.getBean(handlerClass);
        } catch (NoSuchBeanDefinitionException e) {
            // HandlerClass未被Spring管理
            log.error(ExceptionMessage.MSG_002, handlerClass.getSimpleName());
            throw e;
        }
        return handler.handle(request);
    }
}
