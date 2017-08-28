package com.opentae.data.daifa.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 *==========================================================
 *TODO
 *@类编号：
 *@类名称：TsysUserRole.java
 *@文件路径：com.opentae.data.daifa.beans.TsysUserRole
 *@内容摘要：
 *@编码作者：自动生成
 *@完成日期：
 *@Date2017-08-09 04:20:50
 *@comments:
 *
 *=========================================================
 */
public class TsysUserRole implements Serializable {
	
	/**主键*/
	@Id
@GeneratedValue(generator="JDBC")
	private Long userRoleId;
	/**用户Id*/
	private Long userId;
	/**角色Id*/
	private Long roleId;
	/**创建时间*/
	private java.util.Date createTime;
	 
	 //*************************get/set*****************************
    	/**
  	* 
	*get方法
  	*主键
 	*自动生成
  	*/
    public Long getUserRoleId() {
        return userRoleId;
    }

    /**
  	* 
  	*set方法
	*主键
 	*自动生成
  	*/
    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }
	/**
  	* 
	*get方法
  	*用户Id
 	*自动生成
  	*/
    public Long getUserId() {
        return userId;
    }

    /**
  	* 
  	*set方法
	*用户Id
 	*自动生成
  	*/
    public void setUserId(Long userId) {
        this.userId = userId;
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
}
