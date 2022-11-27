package cn.yhm.developer.ecology.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 分页响应参数
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-10-17 21:59:48
 */
@Setter
@Getter
public abstract class PagingResponse<T> implements EcologyResponse {

    /**
     * 总记录数
     */
    @JsonProperty(value = "total", index = 1)
    private Long total;

    /**
     * 当前页码
     */
    @JsonProperty(value = "page_index", index = 2)
    private Long pageIndex;

    /**
     * 每页记录数
     */
    @JsonProperty(value = "page_size", index = 3)
    private Long pageSize;

    /**
     * 结果集
     */
    @JsonProperty(value = "results", index = 4)
    private List<T> results;

}
