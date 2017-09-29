package com.shigu.admin.bo;

import java.io.Serializable;

/**
 * @类编号
 * @类名称：UserAndRoleBO
 * @文件路径：com.shigu.admin.bo.UserAndRoleBO
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/9/21 11:16
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class UserAndRoleBO implements Serializable{
    public Long userId;//用户Id;
    public String roleIds;//多个角色


    public Long getUserId () {
        return userId;
    }

    public void setUserId (Long userId) {
        this.userId = userId;
    }

    public String getRoleIds () {
        return roleIds;
    }

    public void setRoleIds (String roleIds) {
        this.roleIds = roleIds;
    }
}
