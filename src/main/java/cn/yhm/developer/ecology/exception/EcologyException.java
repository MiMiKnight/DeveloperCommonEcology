package cn.yhm.developer.ecology.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * 项目自定义异常
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-09-04 10:27:02
 */
@Getter
@Setter
public class EcologyException extends RuntimeException {

    /**
     * 异常错误码
     */
    private String errorCode;

    /**
     * 异常错误提示消息
     */
    private String errorMsg;

    /**
     * 自定义全局异常
     *
     * @param errorCode 错误码
     * @param errorMsg  错误提示信息
     */
    public EcologyException(String errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

}
