/**
 * @projectName mall-jing
 * @package com.mall.dis.entity
 * @className com.mall.dis.entity.UmsAdminPermissionRelation
 */
package com.mall.dis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * UmsAdminPermissionRelation
 * @description 管理员权限
 * @author shujingping
 * @date 2022/9/23 2:45 下午
 * @version 1.0
 */

@Data
@ApiModel("管理员权限表")
@TableName("ums_admin_permission_relation")
public class UmsAdminPermissionRelation {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("admin_id")
    private Long adminId;
    @TableField("permission_id")
    private Long permissionId;
    @TableField("type")
    private Integer type;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", adminId=").append(adminId);
        sb.append(", permissionId=").append(permissionId);
        sb.append(", type=").append(type);
        sb.append("]");
        return sb.toString();
    }
}
 
