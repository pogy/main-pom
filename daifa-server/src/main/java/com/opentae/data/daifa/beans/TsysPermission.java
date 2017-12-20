package com.opentae.data.daifa.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 *==========================================================
 *TODO
 *@类编号：
 *@类名称：TsysPermission.java
 *@文件路径：com.opentae.data.daifa.beans.TsysPermission
 *@内容摘要：
 *@编码作者：自动生成
 *@完成日期：
 *@Date2017-08-09 04:20:34
 *@comments:
 *
 *=========================================================
 */
public class TsysPermission implements Serializable {
	
	/**主键*/
	@Id
@GeneratedValue(generator="JDBC")
	private Long permissionId;
	/***/
	private String namespace;
	/**权限标签*/
	private String permissionTag;
	/**创建时间*/
	private java.util.Date createTime;
	/**创建者Id*/
	private Long createUserId;
	/**状态，1为可用0为不可用*/
	private Long status;
	/**权限备注*/
	private String permissionComment;
	/***/
	private Long parentPid;
	 
	 //*************************get/set*****************************
    	/**
  	* 
	*get方法
  	*主键
 	*自动生成
  	*/
    public Long getPermissionId() {
        return permissionId;
    }

    /**
  	* 
  	*set方法
	*主键
 	*自动生成
  	*/
    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public String getNamespace() {
        return namespace;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }
	/**
  	* 
	*get方法
  	*权限标签
 	*自动生成
  	*/
    public String getPermissionTag() {
        return permissionTag;
    }

    /**
  	* 
  	*set方法
	*权限标签
 	*自动生成
  	*/
    public void setPermissionTag(String permissionTag) {
        this.permissionTag = permissionTag;
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
  	*创建者Id
 	*自动生成
  	*/
    public Long getCreateUserId() {
        return createUserId;
    }

    /**
  	* 
  	*set方法
	*创建者Id
 	*自动生成
  	*/
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }
	/**
  	* 
	*get方法
  	*状态，1为可用0为不可用
 	*自动生成
  	*/
    public Long getStatus() {
        return status;
    }

    /**
  	* 
  	*set方法
	*状态，1为可用0为不可用
 	*自动生成
  	*/
    public void setStatus(Long status) {
        this.status = status;
    }
	/**
  	* 
	*get方法
  	*权限备注
 	*自动生成
  	*/
    public String getPermissionComment() {
        return permissionComment;
    }

    /**
  	* 
  	*set方法
	*权限备注
 	*自动生成
  	*/
    public void setPermissionComment(String permissionComment) {
        this.permissionComment = permissionComment;
    }
	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public Long getParentPid() {
        return parentPid;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setParentPid(Long parentPid) {
        this.parentPid = parentPid;
    }
}
