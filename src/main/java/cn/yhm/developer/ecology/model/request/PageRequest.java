package cn.yhm.developer.ecology.model.request;

/**
 * 分页请求参数接口
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-09-04 09:34:35
 */
public interface PageRequest extends GatewayRequest {

    /**
     * 获取当前页码
     *
     * @return 当前页码
     */
    Long getPageIndex();


    /**
     * 获取当前页大小
     *
     * @return 页大小
     */
    Long getPageSize();

    /**
     * 计算分页偏移量
     *
     * @return 分页偏移量
     */
    default Long offset() {
        return (getPageIndex() - 1) * getPageSize();
    }
}
