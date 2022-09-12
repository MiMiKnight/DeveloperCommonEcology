package cn.yhm.developer.ecology.constant;

/**
 * 系统常量
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-09-04 20:02:34
 */
public interface SystemConstants {

    /**
     * 日志常量
     */
    interface Log {

        /**
         * Trace_ID键值
         */
        String MDC_TRACE_ID_KEY = "TRACE_ID";

        /**
         * API request日志格式
         */
        String API_LOG_REQUEST_FORMAT = "|URI:{}|Method:{}|Address: {}|Body:{}|";

        /**
         * API response 日志格式
         */
        String API_LOG_RESPONSE_FORMAT = "|URI:{}|Method:{}|Address: {}|Body:{}|";
    }

    /**
     * 错误
     */
     interface Error {
        String ARGUMENT_VALIDATE_ERROR_MSG_FORMAT = "Argument [%s] value validate invalid : %s";
    }
}
