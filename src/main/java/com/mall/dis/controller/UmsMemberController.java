package com.mall.dis.controller;

import com.mall.dis.common.CommonResult;
import com.mall.dis.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author hc
 */

@RestController
@RequestMapping("/sso")
@Api(tags = "会员登录注册管理")
public class UmsMemberController {
    @Autowired
    private UmsMemberService umsMemberService;

    @GetMapping("/getAuthCode")
    @ApiOperation("获取验证码")
    public CommonResult getAuthCode(@RequestParam String telephone) {
        return umsMemberService.generateAuthCode(telephone);
    }

    @PostMapping("/verifyAuthCode")
    @ApiOperation("判断验证码是否正确")
    public CommonResult updatePassword(@RequestParam String telephone,
                                       @RequestParam String authCode) {
        return umsMemberService.verifyAuthCode(telephone, authCode);
    }
}
