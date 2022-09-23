package com.mall.dis.service;

import com.mall.dis.common.CommonResult;

/**
 * 会员管理Service
 * @author hc
 */
public interface UmsMemberService {
    /**
     * 生成验证码
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号码是否匹配
     */
    CommonResult verifyAuthCode(String telephone, String authCode);
}
