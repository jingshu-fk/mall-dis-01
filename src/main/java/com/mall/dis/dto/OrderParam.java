package com.mall.dis.dto;

import lombok.Data;

/**
 * OrderParam
 * @description 生成订单传入的参数
 * @author shujingping
 * @date 2022/12/22 11:00 上午
 * @version 1.0
 */
@Data
public class OrderParam {
    /**
     * 收货地址id
     */
    private Long memberReceiveAddressId;
    /**
     * 优惠券id
      */
    private Long couponId;
    /**
     * 使用的积分数
      */
    private Integer useIntegration;
    /**
     * 支付方式
      */
    private Integer payType;

}
 
