package cn.yhm.developer.ecology.rest.controller;

import cn.yhm.developer.ecology.bean.request.GatewayRequest;
import cn.yhm.developer.ecology.bean.response.GatewayResponse;

/**
 * 网关控制器
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-09-05 01:15:27
 */
public abstract class GatewayController<T extends GatewayResponse, R extends GatewayRequest> {

    /**
     * 处理方法
     *
     * @param request 请求
     * @return response 响应
     */
    public abstract T handle(R request);
}
