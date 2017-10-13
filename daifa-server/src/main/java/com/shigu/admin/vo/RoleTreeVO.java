package com.shigu.admin.vo;

import java.io.Serializable;

/**
 * @类编号
 * @类名称：RoleTreeVO
 * @文件路径：com.shigu.admin.vo.RoleTreeVO
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/9/21 13:19
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class RoleTreeVO implements Serializable{

    private Long roleId;
    /**角色名称*/
    private String roleName;
    /**角色标签*/
    private String roleTag;

    public Long getRoleId () {
        return roleId;
    }

    public void setRoleId (Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName () {
        return roleName;
    }

    public void setRoleName (String roleName) {
        this.roleName = roleName;
    }

    public String getRoleTag () {
        return roleTag;
    }

    public void setRoleTag (String roleTag) {
        this.roleTag = roleTag;
    }
}
