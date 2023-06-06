
package com.mall.dis.controller;

import com.mall.dis.dto.OrderParam;
import com.mall.dis.service.OmsPortalOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * OmsPortalOrderController
 * @description 订单管理controller
 * @author shujingping
 * @date 2022/12/22 11:34 上午
 * @version 1.0
 */
@RestController
@RequestMapping("/order")
@Api(tags = "订单管理")
public class OmsPortalOrderController {
    @Autowired
    private OmsPortalOrderService portalOrderService;

    @ApiOperation("根据购物车信息生成订单")
    @PostMapping("/generateOrder")
    public Object generateOrder(@RequestBody OrderParam orderParam) {
        return portalOrderService.generateOrder(orderParam);
    }

}
 
