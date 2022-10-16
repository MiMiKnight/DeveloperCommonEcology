package cn.yhm.developer.ecology.aspect;


import cn.yhm.developer.ecology.constant.EcologyAspectOrder;
import cn.yhm.developer.ecology.constant.EcologyAspectRule;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    private final String rule = EcologyAspectRule.RULE_2;

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

    /**
     * 环绕通知
     */
    @Around("pointcut()")
    public Object doAround(ProceedingJoinPoint point) throws Throwable {
        log.info("RequestLogAspect...doAround...111111");
        Object proceed = point.proceed();
        log.info("RequestLogAspect...doAround...222222");
        return proceed;
    }

    @Override
    public int getOrder() {
        return EcologyAspectOrder.ORDER_1001;
    }
}
