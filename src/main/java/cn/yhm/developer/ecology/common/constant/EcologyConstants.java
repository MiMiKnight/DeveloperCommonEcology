package cn.yhm.developer.ecology.common.constant;

/**
 * 系统常量
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-09-04 20:02:34
 */
public interface EcologyConstants {

    /**
     * 日志常量
     */
    interface Log {

        /**
         * Trace_ID键值
         */
        String MDC_TRACE_ID_KEY = "TRACE_ID";

        /**
         * API response 日志格式
         * <p>
         * Total：接口响应总耗时
         * <p>
         * Source：请求来源IP
         * <p>
         * Destination：请求目的IP
         * <p>
         * Status：当前响应状态码
         * <p>
         * Method：请求类型（Get、Post、Delete、Put）
         * <p>
         * URI：请求访问路径
         * <p>
         * Response：响应内容
         */
        String API_LOG_RESPONSE_FORMAT = "|Total:{}|Source:{}|Destination:{}|Status:{}|Method:{}|URI:{}||Response:{}|";
    }

    /**
     * 错误
     */
    interface Error {
        String ARGUMENT_VALIDATE_ERROR_MSG_FORMAT = "Argument [%s] value is invalid : %s";
    }

    /**
     * VM Option
     */
    interface VmOption {
        /**
         * 时区Key
         */
        String TIMEZONE_KEY = "user.timezone";

        /**
         * 时区值
         */
        String TIMEZONE_VALUE = TimeZoneGMT.UK.GREENWICH;

        /**
         * 编码Key
         */
        String ENCODING_KEY = "file.encoding";

        /**
         * 编码值
         */
        String ENCODING_VALUE = "UTF-8";

        /**
         * APP Name key
         */
        String APP_NAME_KEY = "app.name";
    }
}
