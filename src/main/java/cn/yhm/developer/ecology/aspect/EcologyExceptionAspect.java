package cn.yhm.developer.ecology.aspect;

import cn.yhm.developer.ecology.constant.ErrorCode;
import cn.yhm.developer.ecology.constant.SystemConstants;
import cn.yhm.developer.ecology.exception.EcologyException;
import cn.yhm.developer.ecology.model.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Objects;

/**
 * 全局异常处理切面
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-09-04 21:42:34
 */
@Slf4j
@Component
@RestControllerAdvice
public class EcologyExceptionAspect {

    /**
     * Error级别异常处理
     * <p>
     * HTTP Code 500
     *
     * @param e Error 错误
     * @return {@link ErrorResponse}
     */
    @ExceptionHandler(value = Error.class)
    @ResponseStatus(value = HttpStatus.NOT_IMPLEMENTED)
    public ErrorResponse handle(Error e) {
        log.error(e.getMessage());
        return ErrorResponse.builder().errorCode(ErrorCode.ERROR).errorMsg("An error occurred during program running").build();
    }

    /**
     * 默认异常处理（Exception级别）
     * <p>
     * HTTP Code 400
     *
     * @param e Exception异常
     * @return {@link ErrorResponse}
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorResponse handle(Exception e) {
        log.error(e.getMessage());
        return ErrorResponse.builder().errorCode(ErrorCode.DEFAULT_EXCEPTION).errorMsg("An exception occurred during program running").build();
    }

    /**
     * 注解校验参数异常处理
     * HTTP Code 400
     *
     * @param e 方法参数未校验异常
     * @return {@link ErrorResponse}
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorResponse handle(MethodArgumentNotValidException e) {
        // 参数字段名
        String field = Objects.requireNonNull(e.getFieldError()).getField();
        // 参数校验提示信息
        String message = e.getFieldError().getDefaultMessage();
        // 错误提示信息
        message = String.format(SystemConstants.Error.ARGUMENT_VALIDATE_ERROR_MSG_FORMAT, field, message);

        return ErrorResponse.builder().errorCode(ErrorCode.ARGUMENT_INVALID).errorMsg(message).build();
    }

    /**
     * 自定义异常处理
     * <p>
     * HTTP Code 400
     *
     * @param e 自定义异常
     * @return {@link ErrorResponse}
     */
    @ExceptionHandler(value = EcologyException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorResponse handle(EcologyException e) {
        return ErrorResponse.builder().errorCode(e.getErrorCode()).errorMsg(e.getErrorMsg()).build();
    }

    /**
     * 资源未找到异常处理
     * <p>
     * HTTP Code 404
     *
     * @param e 资源未找到异常
     * @return {@link ErrorResponse}
     */
    @ExceptionHandler(value = NoHandlerFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorResponse handle(NoHandlerFoundException e) {
        return ErrorResponse.builder().errorCode(ErrorCode.RESOURCE_NOT_FIND).errorMsg("The current access resource is not found").build();
    }

}
