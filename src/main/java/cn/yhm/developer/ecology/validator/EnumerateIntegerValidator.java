package cn.yhm.developer.ecology.validator;

import cn.yhm.developer.ecology.annotation.validate.EnumerateIntegerValidate;
import cn.yhm.developer.ecology.annotation.validate.EnumerateStringValidate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

/**
 * 枚举校验器
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-09-05 07:11:15
 */
public class EnumerateIntegerValidator implements ConstraintValidator<EnumerateIntegerValidate, Integer> {

    /**
     * int类型枚举值
     */
    private int[] enumerations;

    @Override
    public void initialize(EnumerateIntegerValidate validate) {
        this.enumerations = validate.value();
    }


    /**
     * @param value   被校验的参数值
     * @param context context in which the constraint is evaluated
     * @return 布尔
     */
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null || enumerations == null || enumerations.length == 0) {
            return false;
        }
        return Arrays.stream(enumerations).anyMatch(enumeration -> Integer.valueOf(enumeration).equals(value));
    }
}
