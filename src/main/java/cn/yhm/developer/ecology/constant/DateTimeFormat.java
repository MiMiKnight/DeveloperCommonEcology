package cn.yhm.developer.ecology.constant;

/**
 * 日期时间格式
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-09-04 14:20:34
 */
public interface DateTimeFormat {

    /**
     * 24小时制 年月日 时分秒
     */
    String STANDARD_1 = "yyyy-MM-dd HH:mm:ss";

    /**
     * 24小时制 年-月-日 时:分:秒 时区
     * <p>
     * 格式：
     * <p>
     * 2022-09-04 10:06:39 +0800 【表示 东八区 2022年9月4日10点6分39秒】
     */
    String STANDARD_2 = "yyyy-MM-dd HH:mm:ss.SSS";

    /**
     * 24小时制 年-月-日 时:分:秒 时区
     */
    String STANDARD_3 = "yyyy-MM-dd HH:mm:ss z";

    /**
     * 24小时制 年-月-日 时:分:秒.毫秒 时区
     * <p>
     * 格式：
     * <p>
     * 2022-09-04 10:06:39.123 GMT+08:00 【表示 东八区 2022年9月4日10点6分39秒123毫秒】
     * <p>
     * 2022-09-04 10:06:39.123 GMT+00:00 【表示 零时区 2022年9月4日10点6分39秒123毫秒】
     * <p>
     * 2022-09-04 10:06:39.123 GMT-06:00 【表示 西六区 2022年9月4日10点6分39秒123毫秒】
     */
    String STANDARD_4 = "yyyy-MM-dd HH:mm:ss.SSS z";

    /**
     * 年-月-日
     */
    String STANDARD_5 = "yyyy-MM-dd";
}
