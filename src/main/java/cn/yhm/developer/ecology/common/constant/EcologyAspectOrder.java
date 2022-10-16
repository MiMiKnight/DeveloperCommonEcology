package cn.yhm.developer.ecology.common.constant;

import cn.yhm.developer.ecology.aspect.EcologyExceptionAspect;
import cn.yhm.developer.ecology.aspect.RequestLogAspect;
import cn.yhm.developer.ecology.aspect.RequestTraceAspect;

/**
 * 切面顺序常量
 * <p>
 * 切面默认Order数值为Integer最大值
 * <p>
 * 1-99保留，100-299本接口使用
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-09-04 20:08:20
 */
public interface EcologyAspectOrder {

    /**
     * @see RequestTraceAspect
     */
    int ORDER_100 = 100;

    /**
     * @see RequestLogAspect
     */
    int ORDER_101 = 101;

}
