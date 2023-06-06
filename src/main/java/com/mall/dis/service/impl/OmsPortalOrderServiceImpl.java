
package com.mall.dis.service.impl;

import com.mall.dis.common.api.CommonResult;
import com.mall.dis.component.CancelOrderSender;
import com.mall.dis.dto.OrderParam;
import com.mall.dis.service.OmsPortalOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * OmsPortalOrderServiceImpl
 * @description 订单管理
 * @author shujingping
 * @date 2022/12/22 11:23 上午
 * @version 1.0
 */
@Service
public class OmsPortalOrderServiceImpl implements OmsPortalOrderService {
    private static Logger LOGGER = LoggerFactory.getLogger(OmsPortalOrderServiceImpl.class);
    @Autowired
    private CancelOrderSender cancelOrderSender;

    @Override
    public CommonResult generateOrder(OrderParam orderParam) {
        // todo 执行一系列下单操作
        LOGGER.info("process generateOrder");
        // 下单完成后开启一个延迟消息，用于当用户没有付款时取消订单
        sendDelayMessageCancelOrder(11L);
        return CommonResult.success(null, "下单成功");
    }

    @Override
    public void cancelOrder(Long orderId) {
        // todo 执行一系列取消订单操作
        LOGGER.info("process cancelOrder orderId:{}", orderId);
    }

    private void sendDelayMessageCancelOrder(Long orderId) {
        // 获取订单超时时间，假设为60分钟
        long delayTimes = 30 * 1000;
        // 发送延迟消息
        cancelOrderSender.sendMessage(orderId, delayTimes);
    }
}
 
