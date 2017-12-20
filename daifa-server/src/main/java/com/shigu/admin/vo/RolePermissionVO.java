package com.shigu.admin.vo;

import java.io.Serializable;

/**
 * @类编号
 * @类名称：RolePermissionVO
 * @文件路径：com.shigu.admin.vo.RolePermissionVO
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/9/22 15:09
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class RolePermissionVO implements Serializable {
    private Long rolePermissionId;
    /**角色Id*/
    private Long roleId;
    /**权限Id*/
    private Long permissionId;

    public Long getRolePermissionId () {
        return rolePermissionId;
    }

    public void setRolePermissionId (Long rolePermissionId) {
        this.rolePermissionId = rolePermissionId;
    }

    public Long getRoleId () {
        return roleId;
    }

    public void setRoleId (Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId () {
        return permissionId;
    }

    public void setPermissionId (Long permissionId) {
        this.permissionId = permissionId;
    }
}
