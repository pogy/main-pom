package com.shigu.admin.vo;

import java.io.Serializable;

/**
 * @类编号
 * @类名称：PermissionTreeVO
 * @文件路径：com.shigu.admin.vo.PermissionTreeVO
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/9/22 15:03
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class PermissionTreeVO implements Serializable{

    private Long permissionId;

    /**权限标签*/
    private String permissionTag;

    /**权限备注*/
    private String permissionComment;

    public Long getPermissionId () {
        return permissionId;
    }

    public void setPermissionId (Long permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionTag () {
        return permissionTag;
    }

    public void setPermissionTag (String permissionTag) {
        this.permissionTag = permissionTag;
    }

    public String getPermissionComment () {
        return permissionComment;
    }

    public void setPermissionComment (String permissionComment) {
        this.permissionComment = permissionComment;
    }
}
