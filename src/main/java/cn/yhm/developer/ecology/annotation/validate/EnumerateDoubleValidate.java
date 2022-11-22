package cn.yhm.developer.ecology.annotation.validate;

import cn.yhm.developer.ecology.validator.EnumerateDoubleValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * double类型枚举校验注解
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-09-05 07:00:05
 */
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {EnumerateDoubleValidator.class})
public @interface EnumerateDoubleValidate {

    /**
     * 枚举数组
     *
     * @return {@link double[]}
     */
    double[] value() default {};

    /**
     * 精确度
     * <p>
     * 默认精确度 10负3次方（10e-3D）
     */
    double delta() default 10e-3D;

    /**
     * 提示消息
     *
     * @return {@link String}
     */
    String message() default "The parameter value is invalid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
