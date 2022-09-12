package cn.yhm.developer.ecology.annotation;

import cn.yhm.developer.ecology.constant.LogApiType;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * api接口日志注解
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-09-05 00:43:06
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiLog {

    /**
     * 匿名化字段
     */
    String[] anonymous() default "";

    /**
     * 接口类型
     * 增（add）、删()、改（update）、查（query）
     */
    LogApiType type() default LogApiType.Unknown;

}
