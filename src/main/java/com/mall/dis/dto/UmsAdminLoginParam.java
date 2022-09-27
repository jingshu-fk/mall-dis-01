/**
 * @projectName mall-jing
 * @package com.mall.dis.dto
 * @className com.mall.dis.dto.UmsAdminLoginParam
 */
package com.mall.dis.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * UmsAdminLoginParam
 * @description 用户登录参数
 * @author shujingping
 * @date 2022/9/27 11:37 上午
 * @version 1.0
 */

@Data
public class UmsAdminLoginParam {
    @ApiModelProperty(value = "用户名", required = true)
    @NotEmpty(message = "用户名不能为空")
    private String username;
    @ApiModelProperty(value = "密码", required = true)
    @NotEmpty(message = "密码不能为空")
    private String password;
}
 
