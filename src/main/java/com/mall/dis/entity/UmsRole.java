/**
 * @projectName mall-jing
 * @package com.mall.dis.entity
 * @className com.mall.dis.entity.UmsRole
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
 * UmsRole
 * @description 用户角色
 * @author shujingping
 * @date 2022/9/23 4:40 下午
 * @version 1.0
 */

@Data
@ApiModel("用户角色表")
@TableName("ums_role")
public class UmsRole {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("name")
    @ApiModelProperty(value = "名称")
    private String name;

    @TableField("description")
    @ApiModelProperty(value = "描述")
    private String description;

    @TableField("admin_count")
    @ApiModelProperty(value = "后台用户数量")
    private Integer adminCount;

    @TableField("create_time")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @TableField("status")
    @ApiModelProperty(value = "启用状态：0->禁用；1->启用")
    private Integer status;

    @TableField("sort")
    private Integer sort;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", description=").append(description);
        sb.append(", adminCount=").append(adminCount);
        sb.append(", createTime=").append(createTime);
        sb.append(", status=").append(status);
        sb.append(", sort=").append(sort);
        sb.append("]");
        return sb.toString();
    }

}
 
