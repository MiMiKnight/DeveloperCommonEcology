package cn.yhm.developer.ecology.aspect;

import cn.yhm.developer.ecology.common.constant.EcologyConstants;
import cn.yhm.developer.ecology.common.constant.EcologyResponseCode;
import cn.yhm.developer.ecology.common.constant.EcologyResponseMessage;
import cn.yhm.developer.ecology.exception.EcologyException;
import cn.yhm.developer.ecology.model.response.ExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
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

    private interface ResponseMessage extends EcologyResponseMessage {
        String MSG_001 = "Resource Not Be Found";
        String MSG_002 = "Application Default Exception";
        String MSG_003 = "Application Default Error";
        String MSG_004 = "SQL Exception";
        String MSG_005 = "Null Pointer Exception";
        String MSG_006 = "SQL Syntax Error EXCEPTION";
        String MSG_007 = "Request Method Not Supported Exception";
        String MSG_008 = "Application Runtime Exception";

    }

    /**
     * 注解校验参数异常处理
     * HTTP Code 400
     *
     * @param e MethodArgumentNotValidException 注解校验请求入参异常
     * @return {@link ExceptionResponse} 异常响应
     */
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ExceptionResponse handle(MethodArgumentNotValidException e) {
        // 参数字段名
        String field = Objects.requireNonNull(e.getFieldError()).getField();
        // 参数校验提示信息
        String message = e.getFieldError().getDefaultMessage();
        // 错误提示信息
        message = String.format(EcologyConstants.Error.ARGUMENT_VALIDATE_ERROR_MSG_FORMAT, field, message);

        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode(EcologyResponseCode.API.ARGUMENT_INVALID);
        response.setErrorMsg(message);
        return response;
    }

    /**
     * 资源未找到异常处理
     * <p>
     * HTTP Code 404
     *
     * @param e NoHandlerFoundException URI资源未找到异常
     * @return {@link ExceptionResponse} 异常响应
     */
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = NoHandlerFoundException.class)
    public ExceptionResponse handle(NoHandlerFoundException e) {
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode(EcologyResponseCode.System.RESOURCE_NOT_BE_FOUND);
        response.setErrorMsg(ResponseMessage.MSG_001);
        return response;
    }

    /**
     * 请求方法不支持异常
     * <p>
     * HTTP Code 405
     *
     * @param e NoHandlerFoundException 请求方法不支持异常
     * @return {@link ExceptionResponse} 异常响应
     */
    @ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ExceptionResponse handle(HttpRequestMethodNotSupportedException e) {
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode(EcologyResponseCode.System.REQUEST_METHOD_NOT_SUPPORTED_EXCEPTION);
        response.setErrorMsg(ResponseMessage.MSG_007);
        return response;
    }

    /**
     * 默认异常处理（Exception级别）
     * <p>
     * HTTP Code 500
     *
     * @param e Exception异常
     * @return {@link ExceptionResponse} 异常响应
     */
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public ExceptionResponse handle(Exception e) {
        log.error(e.getMessage());
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode(EcologyResponseCode.System.DEFAULT_EXCEPTION);
        response.setErrorMsg(ResponseMessage.MSG_002);
        return response;
    }

    /**
     * 运行时异常处理（RuntimeException级别）
     * <p>
     * HTTP Code 500
     *
     * @param e Exception异常
     * @return {@link ExceptionResponse} 异常响应
     */
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = RuntimeException.class)
    public ExceptionResponse handle(RuntimeException e) {
        log.error(e.getMessage());
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode(EcologyResponseCode.System.RUNTIME_EXCEPTION);
        response.setErrorMsg(ResponseMessage.MSG_008);
        return response;
    }

    /**
     * 空指针异常
     * <p>
     * HTTP Code 500
     *
     * @param e NullPointerException空指针异常
     * @return {@link ExceptionResponse} 异常响应
     */
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = NullPointerException.class)
    public ExceptionResponse handle(NullPointerException e) {
        log.error(e.getMessage());
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode(EcologyResponseCode.System.NULL_POINTER_EXCEPTION);
        response.setErrorMsg(ResponseMessage.MSG_005);
        return response;
    }

    /**
     * Error级别异常处理
     * <p>
     * HTTP Code 501
     *
     * @param e Error 错误
     * @return {@link ExceptionResponse} 异常响应
     */

    @ResponseStatus(value = HttpStatus.NOT_IMPLEMENTED)
    @ExceptionHandler(value = Error.class)
    public ExceptionResponse handle(Error e) {
        log.error(e.getMessage());
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode(EcologyResponseCode.System.ERROR);
        response.setErrorMsg(ResponseMessage.MSG_003);
        return response;
    }

    /**
     * 数据库异常的默认处理方法
     * <p>
     * HTTP Code 502
     *
     * @param e SQLException SQL异常
     * @return {@link ExceptionResponse} 异常响应
     */
    @ResponseStatus(value = HttpStatus.BAD_GATEWAY)
    @ExceptionHandler(value = SQLException.class)
    public ExceptionResponse handle(SQLException e) {
        log.error(e.getMessage());
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode(EcologyResponseCode.Database.SQL_EXCEPTION);
        response.setErrorMsg(ResponseMessage.MSG_004);
        return response;
    }

    /**
     * SQL语法异常
     * <p>
     * HTTP Code 502
     *
     * @param e SQLSyntaxErrorException SQL语法异常
     * @return {@link ExceptionResponse} 异常响应
     */
    @ResponseStatus(value = HttpStatus.BAD_GATEWAY)
    @ExceptionHandler(value = SQLSyntaxErrorException.class)
    public ExceptionResponse handle(SQLSyntaxErrorException e) {
        log.error(e.getMessage());
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode(EcologyResponseCode.Database.SQL_SYNTAX_ERROR_EXCEPTION);
        response.setErrorMsg(ResponseMessage.MSG_006);
        return response;
    }

    /**
     * 自定义异常处理
     * <p>
     *
     * @param e 自定义异常EcologyException
     * @return {@link ExceptionResponse} 异常响应
     */
    @ExceptionHandler(value = EcologyException.class)
    public ExceptionResponse handle(EcologyException e, HttpServletResponse httpServletResponse) {
        // 设置HTTP响应状态码
        httpServletResponse.setStatus(e.getHttpStatusCode());
        return new ExceptionResponse(e);
    }
}
