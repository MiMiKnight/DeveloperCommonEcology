package cn.yhm.developer.ecology.aspect;


import cn.yhm.developer.ecology.constant.AspectOrder;
import cn.yhm.developer.ecology.constant.AspectRule;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * 请求日志切面
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-09-04 19:29:31
 */
@Slf4j
@Component
@Aspect
public class RequestLogAspect implements Ordered {

    /**
     * 切入规则
     */
    private final String rule = AspectRule.RULE_2;

    /**
     * 切入点
     */
    @Pointcut(rule)
    public void pointcut() {
    }

    /**
     * 前置通知
     */
    @Before("pointcut()")
    public void doBefore(JoinPoint point) {
        Signature signature = point.getSignature();
        log.info("RequestLogAspect...doBefore...");
    }

    @Override
    public int getOrder() {
        return AspectOrder.ORDER_1001;
    }
}
