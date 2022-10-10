package cn.yhm.developer.ecology.rest.controller;

import cn.yhm.developer.ecology.model.request.GatewayRequest;
import cn.yhm.developer.ecology.model.response.GatewayResponse;
import cn.yhm.developer.ecology.rest.handler.GatewayHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 网关控制器
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-09-05 01:15:27
 */
@Component
public abstract class GatewayController {

    @Resource
    private ApplicationContext appContext;

    /**
     * 处理方法
     *
     * @param request 请求o
     * @return response 响应
     */
    public <T extends GatewayResponse, R extends GatewayRequest, H extends GatewayHandler<R, T>> T handle(R request, Class<H> handlerClass) throws Exception {
        if (handlerClass == null) {
            throw new IllegalArgumentException("The handlerClass can not be null.");
        }
        H handler = appContext.getBean(handlerClass);
        return handler.handle(request);
    }
}
