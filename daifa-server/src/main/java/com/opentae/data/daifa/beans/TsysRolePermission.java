package com.opentae.data.daifa.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 *==========================================================
 *TODO
 *@类编号：
 *@类名称：TsysRolePermission.java
 *@文件路径：com.opentae.data.daifa.beans.TsysRolePermission
 *@内容摘要：
 *@编码作者：自动生成
 *@完成日期：
 *@Date2017-08-09 04:20:46
 *@comments:
 *
 *=========================================================
 */
public class TsysRolePermission implements Serializable {
	
	/**主键*/
	@Id
@GeneratedValue(generator="JDBC")
	private Long rolePermissionId;
	/**角色Id*/
	private Long roleId;
	/**权限Id*/
	private Long permissionId;
	/**创建时间*/
	private java.util.Date createTime;
	/**最后刷新时间*/
	private java.util.Date lastModifyTime;
	 
	 //*************************get/set*****************************
    	/**
  	* 
	*get方法
  	*主键
 	*自动生成
  	*/
    public Long getRolePermissionId() {
        return rolePermissionId;
    }

    /**
  	* 
  	*set方法
	*主键
 	*自动生成
  	*/
    public void setRolePermissionId(Long rolePermissionId) {
        this.rolePermissionId = rolePermissionId;
    }
	/**
  	* 
	*get方法
  	*角色Id
 	*自动生成
  	*/
    public Long getRoleId() {
        return roleId;
    }

    /**
  	* 
  	*set方法
	*角色Id
 	*自动生成
  	*/
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
	/**
  	* 
	*get方法
  	*权限Id
 	*自动生成
  	*/
    public Long getPermissionId() {
        return permissionId;
    }

    /**
  	* 
  	*set方法
	*权限Id
 	*自动生成
  	*/
    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
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
  	*最后刷新时间
 	*自动生成
  	*/
    public java.util.Date getLastModifyTime() {
        return lastModifyTime;
    }

    /**
  	* 
  	*set方法
	*最后刷新时间
 	*自动生成
  	*/
    public void setLastModifyTime(java.util.Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }
}
