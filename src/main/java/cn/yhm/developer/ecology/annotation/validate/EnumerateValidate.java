package cn.yhm.developer.ecology.annotation.validate;

import cn.yhm.developer.ecology.validator.EnumerateValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 枚举校验注解
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-09-05 07:00:05
 */
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {EnumerateValidator.class})
public @interface EnumerateValidate {

    String[] value() default "";

    String message() default "The date time is ";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
