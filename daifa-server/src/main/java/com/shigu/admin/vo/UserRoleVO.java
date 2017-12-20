package com.shigu.admin.vo;

import java.io.Serializable;

/**
 * @类编号
 * @类名称：UserRoleVO
 * @文件路径：com.shigu.admin.vo.UserRoleVO
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/9/21 13:39
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class UserRoleVO implements Serializable{
    private Long userRoleId;
    /**用户Id*/
    private Long userId;
    /**角色Id*/
    private Long roleId;

    public Long getUserRoleId () {
        return userRoleId;
    }

    public void setUserRoleId (Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Long getUserId () {
        return userId;
    }

    public void setUserId (Long userId) {
        this.userId = userId;
    }

    public Long getRoleId () {
        return roleId;
    }

    public void setRoleId (Long roleId) {
        this.roleId = roleId;
    }
}
