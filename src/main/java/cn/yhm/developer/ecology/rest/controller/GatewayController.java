package cn.yhm.developer.ecology.rest.controller;

import cn.yhm.developer.ecology.model.request.GatewayRequest;
import cn.yhm.developer.ecology.model.response.GatewayResponse;
import cn.yhm.developer.ecology.rest.handler.GatewayHandler;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;

/**
 * 网关控制器
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-09-05 01:15:27
 */
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
     * @param request 请求
     * @return response 响应
     */
    public <T extends GatewayResponse, R extends GatewayRequest, H extends GatewayHandler<R, T>> T handle(R request, Class<H> handlerClass) throws Exception {
        if (handlerClass == null) {
            throw new IllegalArgumentException(ExceptionMessage.MSG_001);
        }
        // HandlerClass not managed by spring
        H handler = appContext.getBean(handlerClass);
        return handler.handle(request);
    }
}
