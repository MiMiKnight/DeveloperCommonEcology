package cn.yhm.developer.ecology.constant;


/**
 * 错误代码
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-09-04 13:22:54
 */
public interface ErrorCode {

    /**
     * 成功响应码
     */
    String SUCCESS = "HD.501001000";

    /**
     * 程序运行发生致命错误
     */
    String ERROR = "HD.501001002";

    /**
     * 默认异常 状态码
     */
    String DEFAULT_EXCEPTION = "HD.501001003";

    /**
     * 参数校验无效 状态码
     */
    String ARGUMENT_INVALID = "HD.501001004";

    /**
     * 资源未找到异常 状态码
     */
    String RESOURCE_NOT_FIND = "HD.501001005";

}
