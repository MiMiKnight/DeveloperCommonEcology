package cn.yhm.developer.ecology.utils;

import cn.yhm.developer.ecology.constant.DateTimeFormat;
import cn.yhm.developer.ecology.constant.TimeZoneGMT;
import cn.yhm.developer.ecology.exception.EcologyException;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * 日期工具类
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-09-04 10:06:39
 */
@Slf4j
public class DateUtils {

    /**
     * OffsetDateTime转日期字符串
     */
    public static String convertOffsetDateTime2Str(OffsetDateTime offsetDateTime, String format, Locale locale) throws Exception {
        if (offsetDateTime == null) {
            throw new NullPointerException("offsetDateTime");
        }
        try {
            return offsetDateTime.format(DateTimeFormatter.ofPattern(format, locale));
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new EcologyException("", "");
        }
    }

    /**
     * 日期字符串转OffsetDateTime
     *
     * @param date   日期字符串
     * @param format 日期格式
     * @param locale 语言环境
     * @return {@link ZonedDateTime}
     * @throws EcologyException 自定义异常
     */
    public static OffsetDateTime convertStr2OffsetDateTime(String date, String format, Locale locale) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format, locale);
        try {
            return OffsetDateTime.parse(date, formatter);
        } catch (Exception e) {
            log.error(e.getMessage());
            // TODO: 待完善
            throw new EcologyException("", "java");
        }
    }

    /**
     * 日期字符串转OffsetDateTime
     * <p>
     * 默认语言环境：English
     *
     * @param date   日期字符串
     * @param format 日期格式
     * @return {@link ZonedDateTime}
     * @throws EcologyException 自定义异常
     */
    public static OffsetDateTime convertStr2OffsetDateTime(String date, String format) throws Exception {
        return convertStr2OffsetDateTime(date, format, Locale.ENGLISH);
    }

    /**
     * 日期字符串转OffsetDateTime
     * <p>
     * 默认语言环境：English
     * <p>
     * 默认字符串日期格式：yyyy-MM-dd HH:mm:ss.SSS Z
     *
     * @param date 日期字符串
     * @return {@link ZonedDateTime}
     * @throws EcologyException 自定义异常
     */
    public static OffsetDateTime convertStr2OffsetDateTime(String date) throws Exception {
        return convertStr2OffsetDateTime(date, DateTimeFormat.STANDARD_4, Locale.ENGLISH);
    }

    /**
     * 日期字符串转ZonedDateTime
     *
     * @param date   日期字符串
     * @param format 日期格式
     * @param locale 语言环境
     * @return {@link ZonedDateTime}
     * @throws EcologyException 自定义异常
     */
    public static ZonedDateTime convertStr2ZonedDateTime(String date, String format, Locale locale) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format, locale);
        try {
            return ZonedDateTime.parse(date, formatter);
        } catch (Exception e) {
            log.error(e.getMessage());
            // TODO: 待完善
            throw new EcologyException("", "java");
        }
    }

    /**
     * 日期字符串转ZonedDateTime
     * <p>
     * 默认English语言环境
     *
     * @param date   日期字符串
     * @param format 日期格式
     * @return {@link ZonedDateTime}
     * @throws EcologyException 自定义异常
     */
    public static ZonedDateTime convertStr2ZonedDateTime(String date, String format) throws Exception {
        return convertStr2ZonedDateTime(date, format, Locale.ENGLISH);
    }

    /**
     * 日期字符串转ZonedDateTime
     * <p>
     * 默认语言环境：English
     * <p>
     * 默认字符串日期格式：yyyy-MM-dd HH:mm:ss.SSS Z
     *
     * @param date 日期字符串
     * @return {@link ZonedDateTime}
     * @throws EcologyException 自定义异常
     */
    public static ZonedDateTime convertStr2ZonedDateTime(String date) throws Exception {
        return convertStr2ZonedDateTime(date, DateTimeFormat.STANDARD_4, Locale.ENGLISH);
    }

    /**
     * 日期字符串转Date
     *
     * @param date   日期字符串
     * @param format 日期格式
     * @param zone   Date对象的时区（此处设置的时区可
     *               能会由于调用parse()解析方法而被覆盖）
     * @param local  语言环境
     * @return {@link Date}
     * @throws EcologyException 自定义异常
     */
    public static Date convertStr2Date(String date, String format, TimeZone zone, Locale local) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format, local);
        // 关闭宽松模式，开启严格模式
        dateFormat.setLenient(false);
        // 设置Date对象的时区 (由此方法设置的TimeZone可能会由于调用parse()解析方法而被覆盖。)
        dateFormat.setTimeZone(zone);
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            log.error(e.getMessage());
            // TODO: 待完善
            throw new EcologyException("", "java");
        }
    }

    /**
     * 日期字符串转Date
     * <p>
     * 默认语言环境：English
     *
     * @param date   日期字符串
     * @param format 日期格式
     * @param zone   Date对象的时区（此处设置的时区可能会由于调用parse()解析方法而被覆盖）
     * @return {@link ZonedDateTime}
     * @throws EcologyException 自定义异常
     */
    public static Date convertStr2Date(String date, String format, TimeZone zone) throws Exception {
        return convertStr2Date(date, format, zone, Locale.ENGLISH);
    }

    /**
     * 日期字符串转Date
     * <p>
     * 默认语言环境：English
     *
     * @param date    日期字符串
     * @param format  日期格式
     * @param zoneGMT Date对象的时区（此处设置的时区可能会由于调用parse()解析方法而被覆盖）
     * @return {@link ZonedDateTime}
     * @throws EcologyException 自定义异常
     */
    public static Date convertStr2Date(String date, String format, String zoneGMT) throws Exception {
        return convertStr2Date(date, format, TimeZone.getTimeZone(zoneGMT), Locale.ENGLISH);
    }

    /**
     * 日期字符串转UTC时区（零时区）的Date
     * <p>
     * 默认语言环境：English
     * <p>
     * 默认时区：GMT+00:00
     * <p>
     * 默认字符串日期格式：yyyy-MM-dd HH:mm:ss
     *
     * @param date 日期字符串
     * @return {@link ZonedDateTime}
     * @throws EcologyException 自定义异常
     */
    public static Date convertStr2DateUTC(String date) throws Exception {
        return convertStr2Date(date, DateTimeFormat.STANDARD_1, TimeZone.getTimeZone(TimeZoneGMT.GMT_0), Locale.ENGLISH);
    }

}
