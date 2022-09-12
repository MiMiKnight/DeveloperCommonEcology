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
public class EcologyException extends Exception {

    /**
     * 异常错误码
     */
    private String errorCode;

    /**
     * 异常错误提示消息
     */
    private String errorMsg;

    public EcologyException() {
        super();
    }

    public EcologyException(String errorCode, String errorMsg) {
        this();
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

}
