package cn.yhm.developer.ecology.rest.controller;

import cn.yhm.developer.ecology.model.request.EcologyRequest;
import cn.yhm.developer.ecology.model.response.EcologyResponse;
import cn.yhm.developer.ecology.rest.handler.EcologyHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;

/**
 * 适配handler方法的前端控制器抽象类
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-09-05 01:15:27
 */
@Slf4j
public abstract class EcologyController {

    private interface ExceptionMessage {
        String MSG_001 = "The handlerClass can not be null.";
        String MSG_002 = "'{}' not managed by spring,add @Componet annotation on this Java Class please.";
    }

    @Resource
    private ApplicationContext appContext;

    /**
     * 处理方法
     *
     * @param request      请求参数
     * @param handlerClass 处理程序类
     * @return response 响应参数
     * @throws Exception 异常
     */
    public <T extends EcologyResponse, R extends EcologyRequest, H extends EcologyHandler<R, T>> T handle(R request,
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
