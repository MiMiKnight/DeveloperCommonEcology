package cn.yhm.developer.ecology.model.entity;

import cn.yhm.developer.ecology.common.constant.TimeZoneGMT;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

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
    void setCreateTime(LocalDateTime createTime);


    /**
     * 设置创建时间
     *
     * @param createTime ZonedDateTime类型创建时间
     */
    default void setCreateTime(ZonedDateTime createTime) {
        ZoneId zoneId = ZoneId.of(TimeZoneGMT.UK.GREENWICH);
        ZonedDateTime zonedDateTime = createTime.withZoneSameInstant(zoneId);
        LocalDateTime localDateTime = zonedDateTime.toLocalDateTime();
        this.setCreateTime(localDateTime);
    }

    /**
     * 获取创建时间
     *
     * @return {@link LocalDateTime} 创建时间
     */
    LocalDateTime getCreateTime();

    /**
     * 获取创建时间
     *
     * @return {@link LocalDateTime} 创建时间
     */
    default ZonedDateTime getCreateTime(ZoneId zoneId) {
        return this.getZonedDateTime(this.getCreateTime(), zoneId);
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    void setUpdateTime(LocalDateTime updateTime);

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    default void setUpdateTime(ZonedDateTime updateTime) {
        ZoneId zoneId = ZoneId.of(TimeZoneGMT.UK.GREENWICH);
        ZonedDateTime zonedDateTime = updateTime.withZoneSameInstant(zoneId);
        LocalDateTime localDateTime = zonedDateTime.toLocalDateTime();
        this.setUpdateTime(localDateTime);
    }

    /**
     * 获取更新时间
     *
     * @return {@link LocalDateTime} 更新时间
     */
    LocalDateTime getUpdateTime();


    /**
     * 乐观锁值自增
     *
     * @param step 步长
     */
    default void selfIncreaseVersion(Integer step) {
        this.setVersion(getVersion() + step);
    }

    /**
     * 乐观锁值自增加1
     */
    default void selfIncreaseVersion() {
        this.selfIncreaseVersion(1);
    }

    /**
     * 为创建时间和更新时间赋统一初始值
     */
    default void assignDateTime() {
        ZoneId zoneId = ZoneId.of(TimeZoneGMT.UK.GREENWICH);
        LocalDateTime dateTime = LocalDateTime.now(zoneId);
        this.assignDateTime(dateTime);
    }

    /**
     * 为创建时间和更新时间赋统一初始值
     *
     * @param dateTime 日期时间
     */
    default void assignDateTime(LocalDateTime dateTime) {
        this.setCreateTime(dateTime);
        this.setUpdateTime(dateTime);
    }


    /**
     * 获取ZonedDateTime类型时间
     *
     * @param dateTime LocalDateTime类型日期时间
     * @param zoneId   定义时间时区
     * @return {@link ZonedDateTime} ZonedDateTime类型时间
     */
    default ZonedDateTime getZonedDateTime(LocalDateTime dateTime, ZoneId zoneId) {
        return ZonedDateTime.of(dateTime, zoneId);
    }

    /**
     * 获取ZonedDateTime类型时间
     *
     * @param dateTime    LocalDateTime类型日期时间
     * @param gmtTimeZone GMT格式时区（例如：GMT+08:00 东八区）
     * @return {@link ZonedDateTime} ZonedDateTime类型时间
     */
    default ZonedDateTime getZonedDateTime(LocalDateTime dateTime, String gmtTimeZone) {
        ZoneId zoneId = ZoneId.of(gmtTimeZone);
        return ZonedDateTime.of(dateTime, zoneId);
    }

    /**
     * 获取ZonedDateTime类型时间
     * <p>
     * 默认时区：零时区 GMT+00:00
     *
     * @param dateTime LocalDateTime类型日期时间
     * @return {@link ZonedDateTime} ZonedDateTime类型时间
     */
    default ZonedDateTime getZonedDateTime(LocalDateTime dateTime) {
        return this.getZonedDateTime(dateTime, TimeZoneGMT.UK.GREENWICH);
    }
}
