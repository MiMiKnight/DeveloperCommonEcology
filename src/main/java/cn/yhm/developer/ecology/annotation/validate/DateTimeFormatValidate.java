package cn.yhm.developer.ecology.annotation.validate;

import cn.yhm.developer.ecology.common.constant.DateTimeFormatPattern;
import cn.yhm.developer.ecology.validator.DateTimeFormatValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 日期时间格式校验注解
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-09-05 01:35:09
 */
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {DateTimeFormatValidator.class})
public @interface DateTimeFormatValidate {

    /**
     * 待校验的日期格式
     *
     * @return {@link String} 日期格式
     */
    String format() default DateTimeFormatPattern.STANDARD_4;

    /**
     * 提示信息
     *
     * @return {@link String} 报错提示信息
     */
    String message() default "The parameter value is invalid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
