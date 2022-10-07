package cn.yhm.developer.ecology.validator;

import cn.yhm.developer.ecology.annotation.validate.EnumerateIntegerValidate;
import cn.yhm.developer.ecology.annotation.validate.EnumerateLongValidate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

/**
 * 枚举校验器
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-09-05 07:11:15
 */
public class EnumerateLongValidator implements ConstraintValidator<EnumerateLongValidate, Long> {

    /**
     * int类型枚举值
     */
    private long[] enumerations;

    @Override
    public void initialize(EnumerateLongValidate validate) {
        this.enumerations = validate.value();
    }


    /**
     * @param value   被校验的参数值
     * @param context context in which the constraint is evaluated
     * @return 布尔
     */
    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (value == null || enumerations == null || enumerations.length == 0) {
            return false;
        }
        return Arrays.stream(enumerations).anyMatch(enumeration -> Long.valueOf(enumeration).equals(value));
    }
}