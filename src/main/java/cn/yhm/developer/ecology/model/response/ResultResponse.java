package cn.yhm.developer.ecology.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 查询结果抽象响应类
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-10-17 07:23:46
 */
@Setter
@Getter
public abstract class ResultResponse<T> implements GatewayResponse {

    /**
     * 查询结果
     */
    @JsonProperty(value = "result", access = JsonProperty.Access.READ_ONLY)
    private T result;
}
