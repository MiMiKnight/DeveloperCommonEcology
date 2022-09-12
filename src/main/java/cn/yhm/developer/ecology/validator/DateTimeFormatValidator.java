package cn.yhm.developer.ecology.validator;

import cn.yhm.developer.ecology.annotation.validate.DateTimeFormatValidate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * 日期时间校验器
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-09-05 01:46:30
 */
public class DateTimeFormatValidator implements ConstraintValidator<DateTimeFormatValidate, String> {

    private String format;

    @Override
    public void initialize(DateTimeFormatValidate validate) {
        this.format = validate.format();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // 如果参数被校验参数为null则校验不通过
        // 如果format为null或者为空则校验不通过
        if (value == null || format == null || "".equals(format.trim())) {
            return false;
        }
        // 如果转换日期转换成功则校验通过，否则报异常则校验不通过
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format, Locale.ENGLISH);
            // 设置严格模式，关闭宽松模式
            dateFormat.setLenient(false);
            dateFormat.parse(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
