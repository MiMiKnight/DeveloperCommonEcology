package cn.yhm.developer.ecology.validator;

import cn.yhm.developer.ecology.annotation.validate.EnumerateDoubleValidate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

/**
 * Double类型枚举校验器
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-09-05 07:11:15
 */
public class EnumerateDoubleValidator implements ConstraintValidator<EnumerateDoubleValidate, Double> {

    /**
     * 枚举数组
     */
    private double[] enumerations;

    /**
     * 精确度
     */
    private double delta;

    @Override
    public void initialize(EnumerateDoubleValidate validate) {
        this.enumerations = validate.value();
        this.delta = validate.delta();
    }


    /**
     * @param value   被校验的参数值
     * @param context 计算约束的上下文
     * @return true：校验通过；false：校验未通过
     */
    @Override
    public boolean isValid(Double value, ConstraintValidatorContext context) {
        if (null == value) {
            return true;
        }
        if (null == enumerations || enumerations.length == 0) {
            return false;
        }
        return Arrays.stream(enumerations).anyMatch(enumeration -> Math.abs(enumeration - value) <= delta);
    }
}