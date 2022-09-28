package com.mall.dis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * UmsRolePermissionRelation
 * @description 角色权限
 * @author shujingping
 * @date 2022/9/23 4:47 下午
 * @version 1.0
 */

@Data
@ApiModel("角色权限关联表")
@TableName("ums_role_permission_relation")
public class UmsRolePermissionRelation {
    private Long id;

    @TableId("role_id")
    private Long roleId;

    @TableField("permission_id")
    private Long permissionId;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", roleId=").append(roleId);
        sb.append(", permissionId=").append(permissionId);
        sb.append("]");
        return sb.toString();
    }
}
 
