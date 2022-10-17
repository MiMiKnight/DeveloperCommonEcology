package cn.yhm.developer.ecology.model.request;

/**
 * 分页请求参数接口
 * <p>
 * 页码变量：pageIndex
 * <p>
 * 每页记录数变量：pageSize
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-09-04 09:34:35
 */
public interface PaginationRequest extends GatewayRequest {

    /**
     * 获取当前页码
     *
     * @return 当前页码
     */
    Long getPageIndex();

    /**
     * 获取每页记录数
     *
     * @return {@link Long} 每页记录数
     */
    Long getPageSize();

    /**
     * 计算分页偏移量
     *
     * @param total 总记录数
     * @return {@link Long} 分页偏移量
     */
    default Long offset(Long total) {
        return offset(total, getPageSize());
    }

    /**
     * 计算分页偏移量
     *
     * @param total    总记录数
     * @param pageSize 每页记录数
     * @return {@link Long} 分页偏移量
     */
    default Long offset(Long total, Long pageSize) {
        if (pageSize == null || pageSize < 1L) {
            throw new IllegalArgumentException();
        }
        return (actualPageIndex(total) - 1) * pageSize;
    }

    /**
     * 计算总页数
     *
     * @param total 总记录数
     * @return {@link Long} 当前分页条件下的总页数
     */
    default Long pages(Long total) {
        return pages(total, getPageSize());
    }

    /**
     * 计算总页数
     *
     * @param total    总记录数
     * @param pageSize 每页记录数
     * @return {@link Long} 当前分页条件下的总页数
     */
    default Long pages(Long total, Long pageSize) {
        if (null == total || total < 0L || pageSize == null || pageSize < 1L) {
            throw new IllegalArgumentException();
        }
        return (total + pageSize - 1L) / pageSize;
    }

    /**
     * 计算实际页码
     *
     * @param total 总记录数
     * @return {@link Long} 实际页码
     */
    default Long actualPageIndex(Long total) {
        return actualPageIndex(getPageIndex(), pages(total));
    }

    /**
     * 计算实际页码
     *
     * @param pageIndex 当前用户传入的页码
     * @param pages     总页数
     * @return {@link Long} 实际页码
     */
    default Long actualPageIndex(Long pageIndex, Long pages) {
        if (pageIndex == null || pageIndex < 1L || pages == null || pages < 0L) {
            throw new IllegalArgumentException();
        }
        // 总页数小于等于0（小于1）
        if (pages < 1L) {
            return pageIndex;
        }
        // 如果页码大于总页数，实际页数为最后一页的页码
        if (pageIndex > pages) {
            return pages;
        }
        return pageIndex;
    }
}
