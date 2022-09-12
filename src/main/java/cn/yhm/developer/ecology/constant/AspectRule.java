package cn.yhm.developer.ecology.constant;

/**
 * 切面规则常量
 * <p>
 * 在多个表达式之间使用与、或、非
 * 与：&&、and
 * 或：||、or
 * 非：!
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-09-04 20:45:10
 */
public interface AspectRule {

    /**
     * 匹配
     * <p>
     * 注解了@RestController或者@Controller注解的类的所有方法
     */
    String RULE_1 = "@within(org.springframework.web.bind.annotation.RestController) || @within(org.springframework.stereotype.Controller)";

    /**
     * 匹配
     * <p>
     * 日志接口注解
     */
    String RULE_2 = "@annotation(cn.yhm.developer.ecology.annotation.ApiLog)";
}
