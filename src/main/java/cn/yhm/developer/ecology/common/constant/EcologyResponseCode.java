package cn.yhm.developer.ecology.common.constant;


/**
 * 响应码
 * <p>
 * 错误码规则：HD.AABBCCC
 * <p>
 * 一级分类：级别 AA
 * <p>
 * {00：成功；01：系统级别的错误；02：API接口参数校验错误；03：数据库级别的错误；04：业务级别的错误}
 * <p>
 * 二级分类：业务模块
 * BB
 * <p>
 * 三级分类：细分类型
 * CCC
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-09-04 13:22:54
 */
public interface EcologyResponseCode {

    /**
     * 成功响应码
     */
    String SUCCESS = "HD.0000000";

    /**
     * 系统级别： AA：01
     */
    interface System {
        /**
         * 程序运行发生致命错误
         */
        String ERROR = "HD.0100000";

        /**
         * 默认异常 状态码
         */
        String DEFAULT_EXCEPTION = "HD.0100001";

        /**
         * 空指针异常 状态码
         */
        String NULL_POINTER_EXCEPTION = "HD.0100002";

        /**
         * 资源未找到异常 状态码
         */
        String RESOURCE_NOT_BE_FOUND = "HD.0100003";

        /**
         * 请求方法不支持异常
         */
        String REQUEST_METHOD_NOT_SUPPORTED_EXCEPTION = "HD.0100004";

        /**
         * 运行时异常 状态码
         */
        String RUNTIME_EXCEPTION = "HD.0100005";
    }

    /**
     * API接口级别 AA：02
     */
    interface API {

        /**
         * 参数校验无效 状态码
         */
        String ARGUMENT_INVALID = "HD.0200000";
    }

    /**
     * 数据库级别 AA：03
     */
    interface Database {
        /**
         * SQL默认异常错误码
         */
        String SQL_EXCEPTION = "HD.0300000";

        /**
         * SQL语法异常错误码
         */
        String SQL_SYNTAX_ERROR_EXCEPTION = "HD.0300001";

    }

}
