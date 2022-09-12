package cn.yhm.developer.ecology.constant;

import lombok.Getter;

/**
 * 日志接口类型
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-09-05 00:59:03
 */
@Getter
public enum LogApiType {

    /**
     * 未知
     */
    Unknown(0, "unknown"),

    /**
     * 增加接口
     */
    Add(1, "add"),

    /**
     * 删除接口
     */
    Delete(2, "delete"),

    /**
     * 更新接口
     */
    Update(3, "update"),

    /**
     * 查询接口
     */
    Query(4, "query");

    /**
     * 接口类型 分类码
     */
    private final Integer code;

    /**
     * 接口类型描述
     */
    private final String type;

    LogApiType(Integer code, String type) {
        this.code = code;
        this.type = type;
    }
}
