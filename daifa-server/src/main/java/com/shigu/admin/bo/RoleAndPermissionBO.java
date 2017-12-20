package com.shigu.admin.bo;

import java.io.Serializable;

/**
 * @类编号
 * @类名称：RoleAndPermissionBO
 * @文件路径：com.shigu.admin.bo.RoleAndPermissionBO
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/9/22 15:13
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class RoleAndPermissionBO implements Serializable{
    private Long roleId;//角色ID
    private String permissionIds;//权限IDs

    public Long getRoleId () {
        return roleId;
    }

    public void setRoleId (Long roleId) {
        this.roleId = roleId;
    }

    public String getPermissionIds () {
        return permissionIds;
    }

    public void setPermissionIds (String permissionIds) {
        this.permissionIds = permissionIds;
    }
}
