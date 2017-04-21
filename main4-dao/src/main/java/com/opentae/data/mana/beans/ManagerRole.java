package com.opentae.data.mana.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 用户角色
 * Created by zhaohongbo on 16/5/10.
 */
public class ManagerRole {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long roleId;
    private String roleName;
    private String roleTag;
    private Date createTime;
    private String roleComment;
    private Long createUserId;
    private Integer status;

    public String getRoleTag() {
        return roleTag;
    }

    public void setRoleTag(String roleTag) {
        this.roleTag = roleTag;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRoleComment() {
        return roleComment;
    }

    public void setRoleComment(String roleComment) {
        this.roleComment = roleComment;
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
}
