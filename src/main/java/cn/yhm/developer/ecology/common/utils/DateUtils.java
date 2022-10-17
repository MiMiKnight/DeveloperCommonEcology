package cn.yhm.developer.ecology.common.utils;

import cn.yhm.developer.ecology.common.constant.DateTimeFormatPattern;
import cn.yhm.developer.ecology.common.constant.TimeZoneGMT;
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
     *
     * @param offsetDateTime offsetDateTime时间对象
     * @param format         格式
     * @param locale         语言环境
     * @return {@link String} 日期字符串
     * @throws NullPointerException 空指针异常
     */
    public static String convertOffsetDateTime2Str(OffsetDateTime offsetDateTime, String format, Locale locale) throws NullPointerException {
        if (offsetDateTime == null) {
            throw new NullPointerException("offsetDateTime");
        }
        return offsetDateTime.format(DateTimeFormatter.ofPattern(format, locale));
    }

    /**
     * 日期字符串转OffsetDateTime
     *
     * @param date   日期字符串
     * @param format 日期格式
     * @param locale 语言环境
     * @return {@link OffsetDateTime OffsetDateTime时间对象}
     */
    public static OffsetDateTime convertStr2OffsetDateTime(String date, String format, Locale locale) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format, locale);
        return OffsetDateTime.parse(date, formatter);
    }

    /**
     * 日期字符串转OffsetDateTime
     * <p>
     * 默认语言环境：English
     *
     * @param date   日期字符串
     * @param format 日期格式
     * @return {@link OffsetDateTime OffsetDateTime时间对象}
     */
    public static OffsetDateTime convertStr2OffsetDateTime(String date, String format) {
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
     * @return {@link OffsetDateTime OffsetDateTime时间对象}
     */
    public static OffsetDateTime convertStr2OffsetDateTime(String date) {
        return convertStr2OffsetDateTime(date, DateTimeFormatPattern.STANDARD_4, Locale.ENGLISH);
    }

    /**
     * 日期字符串转ZonedDateTime
     *
     * @param date   日期字符串
     * @param format 日期格式
     * @param locale 语言环境
     * @return {@link ZonedDateTime ZonedDateTime时间对象}
     */
    public static ZonedDateTime convertStr2ZonedDateTime(String date, String format, Locale locale) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format, locale);
        return ZonedDateTime.parse(date, formatter);
    }

    /**
     * 日期字符串转ZonedDateTime
     * <p>
     * 默认English语言环境
     *
     * @param date   日期字符串
     * @param format 日期格式
     * @return {@link ZonedDateTime ZonedDateTime时间对象}
     */
    public static ZonedDateTime convertStr2ZonedDateTime(String date, String format) {
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
     * @return {@link ZonedDateTime ZonedDateTime时间对象}
     */
    public static ZonedDateTime convertStr2ZonedDateTime(String date) {
        return convertStr2ZonedDateTime(date, DateTimeFormatPattern.STANDARD_4, Locale.ENGLISH);
    }

    /**
     * 日期字符串转Date
     *
     * @param date   日期字符串
     * @param format 日期格式
     * @param zone   Date对象的时区（此处设置的时区可
     *               能会由于调用parse()解析方法而被覆盖）
     * @param local  语言环境
     * @return {@link Date Date时间对象}
     * @throws ParseException 日期解析异常
     */
    public static Date convertStr2Date(String date, String format, TimeZone zone, Locale local) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format, local);
        // 关闭宽松模式，开启严格模式
        dateFormat.setLenient(false);
        // 设置Date对象的时区 (由此方法设置的TimeZone可能会由于调用parse()解析方法而被覆盖。)
        dateFormat.setTimeZone(zone);
        return dateFormat.parse(date)      ;
    }

    /**
     * 日期字符串转Date
     * <p>
     * 默认语言环境：English
     *
     * @param date   日期字符串
     * @param format 日期格式
     * @param zone   Date对象的时区（此处设置的时区可能会由于调用parse()解析方法而被覆盖）
     * @return {@link Date Date时间对象}
     * @throws ParseException 日期解析异常
     */
    public static Date convertStr2Date(String date, String format, TimeZone zone) throws ParseException {
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
     * @return {@link Date Date时间对象}
     * @throws ParseException 日期解析异常
     */
    public static Date convertStr2Date(String date, String format, String zoneGMT) throws ParseException {
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
     * @return {@link Date Date时间对象}
     * @throws ParseException 日期解析异常
     */
    public static Date convertStr2DateUTC(String date) throws ParseException {
        return convertStr2Date(date, DateTimeFormatPattern.STANDARD_1, TimeZone.getTimeZone(TimeZoneGMT.GMT_0), Locale.ENGLISH);
    }

}
