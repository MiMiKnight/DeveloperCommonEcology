package cn.yhm.developer.ecology.model.response;

import cn.yhm.developer.ecology.model.response.GatewayResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * 查询结果集抽象响应类
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-10-17 07:23:46
 */
public abstract class ResultsResponse<T> implements GatewayResponse {

    /**
     * 查询结果集
     */
    @JsonProperty(value = "results", access = JsonProperty.Access.READ_ONLY)
    private List<T> results;
}
