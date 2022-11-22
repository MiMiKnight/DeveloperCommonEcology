package cn.yhm.developer.ecology.rest.handler;

import cn.yhm.developer.ecology.model.request.EcologyRequest;
import cn.yhm.developer.ecology.model.response.EcologyResponse;

/**
 * 处理器接口
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-10-06 18:41:11
 */
public interface EcologyHandler<R extends EcologyRequest, T extends EcologyResponse> {

    /**
     * 处理方法
     *
     * @param request 请求参数
     * @return 响应参数
     * @throws Exception 异常
     */
    T handle(R request) throws Exception;
}
