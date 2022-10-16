package cn.yhm.developer.ecology.aspect;


import cn.yhm.developer.ecology.common.constant.EcologyAspectOrder;
import cn.yhm.developer.ecology.common.constant.EcologyAspectRule;
import cn.yhm.developer.ecology.common.constant.EcologyConstants;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.MDC;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 请求跟踪切面
 * <p>
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-09-04 19:29:31
 */
@Slf4j
@Component
@Aspect
public class RequestTraceAspect implements Ordered {

    /**
     * 切入规则
     */
    private final String rule = EcologyAspectRule.RULE_1;

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
    public void doBefore() {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        // 设置当前请求线程中的跟踪ID
        MDC.put(EcologyConstants.Log.MDC_TRACE_ID_KEY, uuid);
    }

    /**
     * 后置通知
     */
    @After("pointcut()")
    public void doAfter() {
        // 清除当前请求线程中的跟踪ID
        MDC.clear();
    }

    @Override
    public int getOrder() {
        return EcologyAspectOrder.ORDER_100;
    }
}
