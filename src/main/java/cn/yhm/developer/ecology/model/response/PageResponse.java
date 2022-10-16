package cn.yhm.developer.ecology.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 分页响应
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-10-17 07:47:07
 */
@Setter
@Getter
public abstract class PageResponse<T> {

    /**
     * 总记录数
     */
    @JsonProperty(value = "total", index = 1, access = JsonProperty.Access.READ_ONLY)
    private Integer total;

    /**
     * 当前页
     */
    @JsonProperty(value = "page_index", index = 2, access = JsonProperty.Access.READ_ONLY)
    private Integer pageIndex;

    /**
     * 页大小
     */
    @JsonProperty(value = "page_size", index = 3, access = JsonProperty.Access.READ_ONLY)
    private Integer pageSize;

    /**
     * 查询结果集
     */
    @JsonProperty(value = "results", index = 4, access = JsonProperty.Access.READ_ONLY)
    private List<T> results;
}
