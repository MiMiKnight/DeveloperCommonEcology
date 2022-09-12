package cn.yhm.developer.ecology.annotation.validate;

import cn.yhm.developer.ecology.validator.DateTimeFormatValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 日期时间格式
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-09-05 01:35:09
 */
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {DateTimeFormatValidator.class})
public @interface DateTimeFormatValidate {

    String format() default cn.yhm.developer.ecology.constant.DateTimeFormat.STANDARD_4;

    String message() default "The date time is ";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
