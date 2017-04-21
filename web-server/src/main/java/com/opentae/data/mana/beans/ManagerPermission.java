package com.opentae.data.mana.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 权限
 * Created by zhaohongbo on 16/5/10.
 */
public class ManagerPermission {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long permissionId;
    private String namespace;
    private String permissionTag;
    private Date createTime;
    private Long createUserId;
    private Integer status;
    private String permissionComment;

    private Long parentPid;

    public Long getParentPid() {
        return parentPid;
    }

    public void setParentPid(Long parentPid) {
        this.parentPid = parentPid;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getPermissionTag() {
        return permissionTag;
    }

    public void setPermissionTag(String permissionTag) {
        this.permissionTag = permissionTag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPermissionComment() {
        return permissionComment;
    }

    public void setPermissionComment(String permissionComment) {
        this.permissionComment = permissionComment;
    }
}
