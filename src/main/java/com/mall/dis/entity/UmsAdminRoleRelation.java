/**
 * @projectName mall-jing
 * @package com.mall.dis.entity
 * @className com.mall.dis.entity.UmsAdminRoleRelation
 */
package com.mall.dis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * UmsAdminRoleRelation
 * @description 管理员和角色对应关联
 * @author shujingping
 * @date 2022/9/23 3:27 下午
 * @version 1.0
 */

@Data
@ApiModel("管理员和角色关联表")
@TableName("ums_admin_role_relation")
public class UmsAdminRoleRelation {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField("admin_id")
    private Long adminId;
    @TableField("role_id")
    private Long roleId;
}
 
