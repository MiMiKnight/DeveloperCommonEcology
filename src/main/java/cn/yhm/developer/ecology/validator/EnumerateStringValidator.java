package cn.yhm.developer.ecology.validator;

import cn.yhm.developer.ecology.annotation.validate.EnumerateStringValidate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

/**
 * 枚举校验器
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-09-05 07:11:15
 */
public class EnumerateStringValidator implements ConstraintValidator<EnumerateStringValidate, String> {

    /**
     * 枚举值
     */
    private String[] enumerations;

    @Override
    public void initialize(EnumerateStringValidate validate) {
        this.enumerations = validate.value();
    }


    /**
     * @param value   被校验的参数值
     * @param context context in which the constraint is evaluated
     * @return 布尔
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || enumerations == null || enumerations.length == 0) {
            return false;
        }
        return Arrays.asList(enumerations).contains(value);
    }
}
