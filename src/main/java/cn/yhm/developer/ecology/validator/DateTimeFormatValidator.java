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

    /**
     * 日期格式
     */
    private String format;

    /**
     * 日期转换时是否启用宽容模式
     * <p>
     * false 严格模式（缺省值）
     * <p>
     * true 宽容模式
     */
    private boolean lenient;

    @Override
    public void initialize(DateTimeFormatValidate validate) {
        this.format = validate.format();
        this.lenient = validate.lenient();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // 如果参数被校验参数为null且format为null或者为空则校验不通过
        if (value == null || format == null || "".equals(format.trim())) {
            return false;
        }
        // 如果转换日期转换成功则校验通过，否则报异常则校验不通过
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format, Locale.ENGLISH);
            // 设置日期转换时是否宽松模式
            dateFormat.setLenient(lenient);
            dateFormat.parse(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
