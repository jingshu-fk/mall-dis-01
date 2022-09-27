/**
 * @projectName mall-jing
 * @package com.mall.dis.dto
 * @className com.mall.dis.dto.UmsAdminRoleRelationDao
 */
package com.mall.dis.dto;

import com.mall.dis.entity.UmsPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * UmsAdminRoleRelationDao
 * @description 后台用户与角色管理自定义Dao
 * @author shujingping
 * @date 2022/9/27 10:12 上午
 * @version 1.0
 */
public interface UmsAdminRoleRelationDao {
    /**
     * 获取用户所有权限(包括+-权限)
     */
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);
}
