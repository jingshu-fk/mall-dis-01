/**
 * @projectName mall-jing
 * @package com.mall.dis.entity
 * @className com.mall.dis.entity.UmsPermission
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
 * UmsPermission
 * @description 用户菜单权限
 * @author shujingping
 * @date 2022/9/23 3:34 下午
 * @version 1.0
 */

@Data
@ApiModel("用户菜单权限表")
@TableName("ums_permission")
public class UmsPermission {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "父级权限id")
    @TableField("pid")
    private Long pid;

    @TableField("name")
    @ApiModelProperty(value = "名称")
    private String name;

    @TableField("value")
    @ApiModelProperty(value = "权限值")
    private String value;

    @TableField("icon")
    @ApiModelProperty(value = "图标")
    private String icon;

    @TableField("type")
    @ApiModelProperty(value = "权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）")
    private Integer type;

    @TableField("uri")
    @ApiModelProperty(value = "前端资源路径")
    private String uri;

    @TableField("status")
    @ApiModelProperty(value = "启用状态；0->禁用；1->启用")
    private Integer status;

    @TableField("create_time")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @TableField("sort")
    @ApiModelProperty(value = "排序")
    private Integer sort;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pid=").append(pid);
        sb.append(", name=").append(name);
        sb.append(", value=").append(value);
        sb.append(", icon=").append(icon);
        sb.append(", type=").append(type);
        sb.append(", uri=").append(uri);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", sort=").append(sort);
        sb.append("]");
        return sb.toString();
    }
}
 
