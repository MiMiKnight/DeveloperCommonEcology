package cn.yhm.developer.ecology.annotation;

import cn.yhm.developer.ecology.common.enumeration.ApiType;

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
     *
     * @return {@link String[] 匿名化字段数组}
     */
    String[] anonymous() default "";

    /**
     * 接口类型
     * 增（save）、删(delete)、改（update）、查（query）
     *
     * @return {@link ApiType 接口类型枚举}
     */
    ApiType type() default ApiType.Unknown;

}
