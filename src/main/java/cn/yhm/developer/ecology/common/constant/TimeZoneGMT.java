package cn.yhm.developer.ecology.common.constant;

/**
 * 格林尼治时间时区
 * <p>
 * P：Positive 正
 * N：Negative 负
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-09-04 14:18:06
 */
public interface TimeZoneGMT {

    /**
     * 东十一区
     */
    String GMT_P_11 = "GMT+11:00";

    /**
     * 东十区
     */
    String GMT_P_10 = "GMT+10:00";

    /**
     * 东九区
     */
    String GMT_P_9 = "GMT+09:00";

    /**
     * 东八区
     */
    String GMT_P_8 = "GMT+08:00";

    /**
     * 东七区
     */
    String GMT_P_7 = "GMT+07:00";

    /**
     * 东六区
     */
    String GMT_P_6 = "GMT+06:00";

    /**
     * 东五区
     */
    String GMT_P_5 = "GMT+05:00";

    /**
     * 东四区
     */
    String GMT_P_4 = "GMT+04:00";

    /**
     * 东三区
     */
    String GMT_P_3 = "GMT+03:00";

    /**
     * 东二区
     */
    String GMT_P_2 = "GMT+02:00";

    /**
     * 东一区
     */
    String GMT_P_1 = "GMT+01:00";

    /**
     * 零时区
     */
    String GMT_0 = "GMT+00:00";

    /**
     * 西一区
     */
    String GMT_N_1 = "GMT-01:00";

    /**
     * 西二区
     */
    String GMT_N_2 = "GMT-02:00";

    /**
     * 西三区
     */
    String GMT_N_3 = "GMT-03:00";

    /**
     * 西四区
     */
    String GMT_N_4 = "GMT-04:00";

    /**
     * 西五区
     */
    String GMT_N_5 = "GMT-05:00";

    /**
     * 西六区
     */
    String GMT_N_6 = "GMT-06:00";

    /**
     * 西七区
     */
    String GMT_N_7 = "GMT-07:00";

    /**
     * 西八区
     */
    String GMT_N_8 = "GMT-08:00";

    /**
     * 西九区
     */
    String GMT_N_9 = "GMT-09:00";

    /**
     * 西十区
     */
    String GMT_N_10 = "GMT-10:00";

    /**
     * 西十一区
     */
    String GMT_N_11 = "GMT-11:00";


    /**
     * 中国的时区分类
     */
    interface China {

        /**
         * 北京时区
         */
        String BEIJING = GMT_P_8;
    }

    /**
     * 英国的时区分类
     */
    interface UK {

        /**
         * 格林尼治时区
         */
        String GREENWICH = GMT_0;
    }

    /**
     * 美国时区分类
     */
    interface USA {

        /**
         * 美国东部标准时间 西五区
         * <p>
         * 包括大西洋沿岸及近大陆的19个州和华盛顿特区，代表城市华盛顿、纽约
         */
        String EST = GMT_N_5;

        /**
         * 美国中部标准时间 西六区
         * <p>
         * 代表城市芝加哥、新奥尔良；
         */
        String CST = GMT_N_6;

        /**
         * 美国西部山地标准时间 西七区
         * <p>
         * 代表城市盐湖城、丹佛；
         */
        String MST = GMT_N_7;

        /**
         * 美国西部山地标准时间 西八区
         * <p>
         * 包括太平洋沿岸的4个州，代表城市旧金山、洛杉矶、西雅图；
         */
        String PST = GMT_N_8;

        /**
         * 美国阿拉斯加标准时间 西九区
         * <p>
         * 只限于阿拉斯加，代表城市费尔班克斯；
         */
        String AKST = GMT_N_9;

        /**
         * 夏威夷标准时间 西十区
         * <p>
         * 只限于夏威夷，代表城市火奴鲁鲁
         */
        String HST = GMT_N_10;

    }

}
