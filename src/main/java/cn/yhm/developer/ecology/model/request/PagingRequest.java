package cn.yhm.developer.ecology.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 分页参数请求抽象类
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-10-17 21:51:34
 */
@Setter
@Getter
public abstract class PagingRequest implements PaginationRequest {

    /**
     * 当前页码
     */
    @NotNull(message = "The parameter can not be null")
    @Min(value = 1L, message = "The minimum value of the parameter is 1")
    @Max(value = Integer.MAX_VALUE, message = "The maximum value of the parameter is Integer.MAX_VALUE")
    @JsonProperty(value = "page_index", access = JsonProperty.Access.WRITE_ONLY)
    private Long pageIndex = 1L;

    /**
     * 每页记录数
     */
    @NotNull(message = "The parameter can not be null")
    @Min(value = 1L, message = "The minimum value of the parameter is 1")
    @Max(value = 100, message = "The maximum value of the parameter is 100")
    @JsonProperty(value = "page_size", access = JsonProperty.Access.WRITE_ONLY)
    private Long pageSize = 5L;

}
