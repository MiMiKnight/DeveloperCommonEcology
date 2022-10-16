package cn.yhm.developer.ecology.constant;

import lombok.Getter;

/**
 * 接口类型
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-09-05 00:59:03
 */
@Getter
public enum ApiType {

    /**
     * 未知
     */
    Unknown(0, "unknown"),

    /**
     * 保存接口
     */
    Save(1, "save"),

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
     * 接口类型  描述
     */
    private final String type;

    ApiType(Integer code, String type) {
        this.code = code;
        this.type = type;
    }
}
