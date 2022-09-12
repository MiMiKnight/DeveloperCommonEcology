package cn.yhm.developer.ecology.constant;

import cn.yhm.developer.ecology.aspect.RequestLogAspect;
import cn.yhm.developer.ecology.aspect.RequestTraceAspect;

/**
 * 切面顺序常量
 * <p>
 * 切面默认Order数值为Integer最大值
 * <p>
 * 本常量接口Order从1000开始，之前序号保留以后使用
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-09-04 20:08:20
 */
public interface AspectOrder {

    /**
     * @see RequestTraceAspect
     */
    int ORDER_1000 = 1000;

    /**
     * @see RequestLogAspect
     */
    int ORDER_1001 = 1001;
}
