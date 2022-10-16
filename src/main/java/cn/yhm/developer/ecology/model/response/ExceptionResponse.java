package cn.yhm.developer.ecology.model.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * 程序发生异常时的响应参数类
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-09-04 09:40:47
 */
@Builder
@Getter
@Setter
public class ExceptionResponse implements GatewayResponse {

    /**
     * 错误码
     */
    @JsonProperty(value = "error_code", index = 1, access = JsonProperty.Access.READ_ONLY)
    private String errorCode;


    /**
     * 错误提示信息
     */
    @JsonProperty(value = "error_msg", index = 2, access = JsonProperty.Access.READ_ONLY)
    private String errorMsg;

}
