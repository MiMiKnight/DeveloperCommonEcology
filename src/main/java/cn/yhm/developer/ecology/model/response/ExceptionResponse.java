package cn.yhm.developer.ecology.model.response;


import cn.yhm.developer.ecology.exception.EcologyException;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 程序发生异常时的响应参数类
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-09-04 09:40:47
 */
@Getter
@Setter
public class ExceptionResponse implements EcologyResponse {

    /**
     * 错误码
     */
    @JsonProperty(value = "error_code", index = 1)
    private String errorCode;


    /**
     * 错误提示信息
     */
    @JsonProperty(value = "error_msg", index = 2)
    private String errorMsg;


    public ExceptionResponse() {

    }

    /**
     * @param errorCode 错误码
     * @param errorMsg  错误提示信息
     */
    public ExceptionResponse(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    /**
     * @param e 自定义异常
     */
    public ExceptionResponse(EcologyException e) {
        this(e.getErrorCode(), e.getErrorMsg());
    }
    

}