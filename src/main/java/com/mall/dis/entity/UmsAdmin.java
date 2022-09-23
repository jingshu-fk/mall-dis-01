/**
 * @projectName mall-jing
 * @package com.mall.dis.entity
 * @className com.mall.dis.entity.UmsAdmin
 */
package com.mall.dis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * UmsAdmin
 * @description 管理员
 * @author shujingping
 * @date 2022/9/23 2:12 下午
 * @version 1.0
 */
@Data
@ApiModel("管理员表")
@TableName("ums_admin")
public class UmsAdmin {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String username;

    private String password;

    @TableField("icon")
    @ApiModelProperty("头像")
    private String icon;

    @TableField("email")
    @ApiModelProperty("邮箱")
    private String email;

    @TableField("nick_name")
    @ApiModelProperty("昵称")
    private String nickName;

    @TableField("note")
    @ApiModelProperty(value = "备注信息")
    private String note;

    @TableField("create_time")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @TableField("login_time")
    @ApiModelProperty(value = "最后登录时间")
    private Date loginTime;

    @TableField("status")
    @ApiModelProperty(value = "帐号启用状态：0->禁用；1->启用")
    private Integer status;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", icon=").append(icon);
        sb.append(", email=").append(email);
        sb.append(", nickName=").append(nickName);
        sb.append(", note=").append(note);
        sb.append(", createTime=").append(createTime);
        sb.append(", loginTime=").append(loginTime);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}
 
