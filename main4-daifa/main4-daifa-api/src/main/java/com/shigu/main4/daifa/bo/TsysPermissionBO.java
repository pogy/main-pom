package com.shigu.main4.daifa.bo;

import java.io.Serializable;
import java.util.Date;

/**
 * @类编号
 * @类名称：TsysPermissionBO
 * @文件路径：com.shigu.main4.daifa.bo.TsysPermissionBO
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/9/20 10:47
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class TsysPermissionBO implements Serializable{

    private Long permissionId;//主键
    //namespace
    private String namespace;//
    //permission_tag
    private String permissionTag;//权限标签
    //create_time
    private java.util.Date createTime;//创建时间
    //create_user_id
    private Long createUserId;//创建者Id
    //status
    private Long status;//状态，1为可用0为不可用
    //permission_comment
    private String permissionComment;//权限备注
    //parent_pid
    private Long parentPid;//

    public Long getPermissionId () {
        return permissionId;
    }

    public void setPermissionId (Long permissionId) {
        this.permissionId = permissionId;
    }

    public String getNamespace () {
        return namespace;
    }

    public void setNamespace (String namespace) {
        this.namespace = namespace;
    }

    public String getPermissionTag () {
        return permissionTag;
    }

    public void setPermissionTag (String permissionTag) {
        this.permissionTag = permissionTag;
    }

    public Date getCreateTime () {
        return createTime;
    }

    public void setCreateTime (Date createTime) {
        this.createTime = createTime;
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

    public String getPermissionComment () {
        return permissionComment;
    }

    public void setPermissionComment (String permissionComment) {
        this.permissionComment = permissionComment;
    }

    public Long getParentPid () {
        return parentPid;
    }

    public void setParentPid (Long parentPid) {
        this.parentPid = parentPid;
    }
}
