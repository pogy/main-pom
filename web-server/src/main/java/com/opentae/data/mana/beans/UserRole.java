package com.opentae.data.mana.beans;

/**
 * 用户角色对象
 * Created by zhaohongbo on 16/5/12.
 */
public class UserRole {

    private Long userId;
    private Long roleId;
    private String roleName;
    private Integer roleStatus;

    private String roleTag;

    private String roleComment;

    public String getRoleTag() {
        return roleTag;
    }

    public void setRoleTag(String roleTag) {
        this.roleTag = roleTag;
    }

    public String getRoleComment() {
        return roleComment;
    }

    public void setRoleComment(String roleComment) {
        this.roleComment = roleComment;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(Integer roleStatus) {
        this.roleStatus = roleStatus;
    }
}
