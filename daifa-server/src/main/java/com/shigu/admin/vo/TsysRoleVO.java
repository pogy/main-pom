package com.shigu.admin.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @类编号
 * @类名称：TsysRoleVO
 * @文件路径：com.shigu.daifa.vo.TsysRoleVO
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/9/18 09:29
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class TsysRoleVO implements Serializable{
    private Long roleId;
    /**角色名称*/
    private String roleName;
    /**角色标签*/
    private String roleTag;
    /**创建时间*/
    private String createTime;
    /**角色备注*/
    private String roleComment;
    /**登陆者用户ID*/
    private Long createUserId;
    /**可用性，1为可用，0为不可用*/
    private Long status;
    /***/
    private String remark1;
    /***/
    private String remark2;

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

    public String getCreateTime () {
        return createTime;
    }

    public void setCreateTime (String createTime) {
        this.createTime = createTime;
    }

    public String getRoleComment () {
        return roleComment;
    }

    public void setRoleComment (String roleComment) {
        this.roleComment = roleComment;
    }

    public Long getCreateUserId () {
        return createUserId;
    }

    public void setCreateUserId (Long createUserId) {
        this.createUserId = createUserId;
    }

    public Long getStatus () {
        return status;
    }

    public void setStatus (Long status) {
        this.status = status;
    }

    public String getRemark1 () {
        return remark1;
    }

    public void setRemark1 (String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2 () {
        return remark2;
    }

    public void setRemark2 (String remark2) {
        this.remark2 = remark2;
    }
}
