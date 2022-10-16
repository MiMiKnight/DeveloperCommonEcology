package cn.yhm.developer.ecology.annotation.validate;

import cn.yhm.developer.ecology.constant.DateTimeFormatPattern;
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

    /**
     * 待校验的日期格式
     */
    String format() default DateTimeFormatPattern.STANDARD_4;

    /**
     * 日期转换时是否启用宽容模式
     * <p>
     * false 严格模式（缺省值）
     * <p>
     * true 宽容模式
     */
    boolean lenient() default false;

    String message() default "The parameter value is invalid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
