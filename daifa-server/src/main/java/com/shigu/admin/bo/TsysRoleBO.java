package com.shigu.admin.bo;

import java.io.Serializable;
import java.util.Date;

/**
 * @类编号
 * @类名称：TsysRoleBO
 * @文件路径：com.shigu.daifa.bo.TsysRoleBO
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/9/18 09:29
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class TsysRoleBO implements Serializable{

    /**创建日期的开始*/
    private String startTime;
    /**创建日期的结束*/
    private String endTime;
    /**角色名称*/
    private String roleName;
    /**角色标签*/
    private String roleTag;
    /**登陆者用户ID*/
    private Long createUserId;
    /**可用性，1为可用，0为不可用*/
    private Long status;
    /**角色备注*/
    private String roleComment;
    /**角色ID*/
    private Long roleId;
    /**
     * 当前页
     */
    private String page;
    /**
     * 总数量
     */
    private Integer count;

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

    public String getPage () {
        return page;
    }

    public void setPage (String page) {
        this.page = page;
    }

    public Integer getCount () {
        return count;
    }

    public void setCount (Integer count) {
        this.count = count;
    }

    public String getRoleComment () {
        return roleComment;
    }

    public void setRoleComment (String roleComment) {
        this.roleComment = roleComment;
    }

    public Long getRoleId () {
        return roleId;
    }

    public void setRoleId (Long roleId) {
        this.roleId = roleId;
    }

   
}
