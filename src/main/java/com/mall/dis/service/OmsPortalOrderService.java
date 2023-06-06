
package com.mall.dis.service;

import com.mall.dis.common.api.CommonResult;
import com.mall.dis.dto.OrderParam;
import org.springframework.transaction.annotation.Transactional;

/**
 * OmsPortalOrderService
 * @description 订单管理
 * @author shujingping
 * @date 2022/12/22 10:56 上午
 * @version 1.0
 */
public interface OmsPortalOrderService {
    /**
     * 根据提交信息生成订单
     */
    @Transactional
    CommonResult generateOrder(OrderParam orderParam);

    /**
     * 取消单个超时订单
     */
    @Transactional
    void cancelOrder(Long orderId);
}
