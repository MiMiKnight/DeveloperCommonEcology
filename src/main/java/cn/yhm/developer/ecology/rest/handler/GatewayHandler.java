package cn.yhm.developer.ecology.rest.handler;

import cn.yhm.developer.ecology.model.request.GatewayRequest;
import cn.yhm.developer.ecology.model.response.GatewayResponse;

/**
 * 网关处理器接口
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-10-06 18:41:11
 */
public interface GatewayHandler<R extends GatewayRequest, T extends GatewayResponse> {
    /**
     * 处理方法
     *
     * @param request 请求
     * @return 响应
     * @throws Exception 异常
     */
    T handle(R request) throws Exception;
}
