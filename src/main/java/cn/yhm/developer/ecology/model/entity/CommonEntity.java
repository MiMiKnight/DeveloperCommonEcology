package cn.yhm.developer.ecology.model.entity;

import java.util.Date;

/**
 * 自定义通用实体类接口
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-10-18 23:36:14
 */
public interface CommonEntity {

    /**
     * 设置乐观锁字段
     *
     * @param version 乐观锁
     */
    void setVersion(Integer version);

    /**
     * 获得乐观锁字段
     *
     * @return {@link Integer} 乐观锁值
     */
    Integer getVersion();

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    void setCreateTime(Date createTime);

    /**
     * 获取创建时间
     *
     * @return 创建时间
     */
    Date getCreateTime();

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    void setUpdateTime(Date updateTime);

    /**
     * 获取更新时间
     *
     * @return 更新时间
     */
    Date getUpdateTime();

    /**
     * 乐观锁值自增
     */
    default void selfIncreaseVersion() {
        this.setVersion(getVersion() + 1);
    }

    /**
     * 为创建时间和更新时间赋统一初始值
     */
    default void assignDateTime() {
        this.assignDateTime(new Date());
    }

    /**
     * 为创建时间和更新时间赋统一初始值
     *
     * @param date 日期时间
     */
    default void assignDateTime(Date date) {
        this.setCreateTime(date);
        this.setUpdateTime(date);
    }

}
