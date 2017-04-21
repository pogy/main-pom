package com.opentae.data.mana.beans;

/**
 * 角色权限
 * Created by zhaohongbo on 16/5/13.
 */
public class RolePermission {

    private Long roleId;
    private Long permissionId;
    private String permissionTag;
    private Integer permissionStatus;

    private Long parentPid;

    private String permissionComment;


    public Long getParentPid() {
        return parentPid;
    }

    public void setParentPid(Long parentPid) {
        this.parentPid = parentPid;
    }

    public String getPermissionComment() {
        return permissionComment;
    }

    public void setPermissionComment(String permissionComment) {
        this.permissionComment = permissionComment;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionTag() {
        return permissionTag;
    }

    public void setPermissionTag(String permissionTag) {
        this.permissionTag = permissionTag;
    }

    public Integer getPermissionStatus() {
        return permissionStatus;
    }

    public void setPermissionStatus(Integer permissionStatus) {
        this.permissionStatus = permissionStatus;
    }
}
