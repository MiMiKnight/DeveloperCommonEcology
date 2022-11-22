package cn.yhm.developer.ecology.validator;

import cn.yhm.developer.ecology.annotation.validate.EnumerateIntegerValidate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

/**
 * Integer类型枚举校验器
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-09-05 07:11:15
 */
public class EnumerateIntegerValidator implements ConstraintValidator<EnumerateIntegerValidate, Integer> {

    /**
     * 枚举数组
     */
    private int[] enumerations;

    @Override
    public void initialize(EnumerateIntegerValidate validate) {
        this.enumerations = validate.value();
    }


    /**
     * @param value   被校验的参数值
     * @param context 计算约束的上下文
     * @return true：校验通过；false：校验未通过
     */
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (null == value) {
            return true;
        }
        if (null == enumerations || enumerations.length == 0) {
            return false;
        }
        return Arrays.stream(enumerations).anyMatch(enumeration -> value == enumeration);
    }
}
