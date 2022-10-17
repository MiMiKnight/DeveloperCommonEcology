package cn.yhm.developer.ecology.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 分页响应
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-10-17 21:59:48
 */
@Accessors(chain = true)
@Setter
@Getter
public abstract class PagingResponse<T> implements GatewayResponse {

    /**
     * 总记录数
     */
    @JsonProperty(value = "total", index = 1, access = JsonProperty.Access.READ_ONLY)
    private Long total;

    /**
     * 当前页码
     */
    @JsonProperty(value = "page_index", index = 2, access = JsonProperty.Access.READ_ONLY)
    private Long pageIndex;

    /**
     * 每页记录数
     */
    @JsonProperty(value = "page_size", index = 3, access = JsonProperty.Access.READ_ONLY)
    private Long pageSize;

    /**
     * 结果集
     */
    @JsonProperty(value = "results", index = 4, access = JsonProperty.Access.READ_ONLY)
    private List<T> results;

}
