package cn.yhm.developer.ecology.annotation.validate;

import cn.yhm.developer.ecology.validator.EnumerateLongValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * long类型枚举校验注解
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-09-05 07:00:05
 */
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {EnumerateLongValidator.class})
public @interface EnumerateLongValidate {

    /**
     * 枚举数组
     *
     * @return {@link long[]}
     */
    long[] value() default {};

    /**
     * 提示信息
     *
     * @return {@link String}
     */
    String message() default "The parameter value is invalid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
