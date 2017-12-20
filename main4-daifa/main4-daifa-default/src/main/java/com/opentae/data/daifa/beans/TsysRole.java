package com.opentae.data.daifa.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 *==========================================================
 *TODO
 *@类编号：
 *@类名称：TsysRole.java
 *@文件路径：com.opentae.data.daifa.beans.TsysRole
 *@内容摘要：
 *@编码作者：自动生成
 *@完成日期：
 *@Date2017-08-09 04:20:42
 *@comments:
 *
 *=========================================================
 */
public class TsysRole implements Serializable {
	
	/**主键*/
	@Id
@GeneratedValue(generator="JDBC")
	private Long roleId;
	/**角色名称*/
	private String roleName;
	/**角色标签*/
	private String roleTag;
	/**创建时间*/
	private java.util.Date createTime;
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
	 
	 //*************************get/set*****************************
    	/**
  	* 
	*get方法
  	*主键
 	*自动生成
  	*/
    public Long getRoleId() {
        return roleId;
    }

    /**
  	* 
  	*set方法
	*主键
 	*自动生成
  	*/
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
	/**
  	* 
	*get方法
  	*角色名称
 	*自动生成
  	*/
    public String getRoleName() {
        return roleName;
    }

    /**
  	* 
  	*set方法
	*角色名称
 	*自动生成
  	*/
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
	/**
  	* 
	*get方法
  	*角色标签
 	*自动生成
  	*/
    public String getRoleTag() {
        return roleTag;
    }

    /**
  	* 
  	*set方法
	*角色标签
 	*自动生成
  	*/
    public void setRoleTag(String roleTag) {
        this.roleTag = roleTag;
    }
	/**
  	* 
	*get方法
  	*创建时间
 	*自动生成
  	*/
    public java.util.Date getCreateTime() {
        return createTime;
    }

    /**
  	* 
  	*set方法
	*创建时间
 	*自动生成
  	*/
    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }
	/**
  	* 
	*get方法
  	*角色备注
 	*自动生成
  	*/
    public String getRoleComment() {
        return roleComment;
    }

    /**
  	* 
  	*set方法
	*角色备注
 	*自动生成
  	*/
    public void setRoleComment(String roleComment) {
        this.roleComment = roleComment;
    }
	/**
  	* 
	*get方法
  	*登陆者用户ID
 	*自动生成
  	*/
    public Long getCreateUserId() {
        return createUserId;
    }

    /**
  	* 
  	*set方法
	*登陆者用户ID
 	*自动生成
  	*/
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }
	/**
  	* 
	*get方法
  	*可用性，1为可用，0为不可用
 	*自动生成
  	*/
    public Long getStatus() {
        return status;
    }

    /**
  	* 
  	*set方法
	*可用性，1为可用，0为不可用
 	*自动生成
  	*/
    public void setStatus(Long status) {
        this.status = status;
    }
	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public String getRemark1() {
        return remark1;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }
	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public String getRemark2() {
        return remark2;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }
}
