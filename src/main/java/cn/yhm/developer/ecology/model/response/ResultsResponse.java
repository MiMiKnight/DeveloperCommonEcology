package cn.yhm.developer.ecology.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 结果集抽象响应类
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-10-17 07:23:46
 */
@Accessors(chain = true)
@Setter
@Getter
public abstract class ResultsResponse<T> implements GatewayResponse {

    /**
     * 结果集
     */
    @JsonProperty(value = "results", access = JsonProperty.Access.READ_ONLY)
    private List<T> results;
}
