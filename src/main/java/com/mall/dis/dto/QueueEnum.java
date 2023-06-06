/**
 * @projectName mall-jing
 * @package com.mall.dis.dto
 * @className com.mall.dis.dto.QueueEnum
 */
package com.mall.dis.dto;


import lombok.Getter;

/**
 * QueueEnum
 * @description 消息队列常量定义
 * @author shujingping
 * @date 2022/12/22 9:59 上午
 * @version 1.0
 */

@Getter
public enum QueueEnum {
    /**
     * 消息通知队列
     */
    QUEUE_ORDER_CANCEL("mall.order.direct", "mall.order.cancel", "mall.order.cancel"),
    /**
     * 消息通知ttl队列
     */
    QUEUE_TTL_ORDER_CANCEL("mall.order.direct.ttl", "mall.order.cancel.ttl", "mall.order.cancel.ttl");

    /**
     * 交换名称
     */
    private final String exchange;
    /**
     * 队列名称
     */
    private final String name;
    /**
     * 路由键
     */
    private final String routeKey;

    QueueEnum(String exchange, String name, String routeKey) {
        this.exchange = exchange;
        this.name = name;
        this.routeKey = routeKey;
    }

}
