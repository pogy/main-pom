package com.opentae.data.daifa.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 *==========================================================
 *TODO
 *@类编号：
 *@类名称：DaifaWorker.java
 *@文件路径：com.opentae.data.daifa.beans.DaifaWorker
 *@内容摘要：
 *@编码作者：自动生成
 *@完成日期：
 *@Date2017-08-09 04:19:57
 *@comments:
 *
 *=========================================================
 */
public class DaifaWorker implements Serializable {
	
	/***/
	@Id
@GeneratedValue(generator="JDBC")
	private Long daifaWorkerId;
	/***/
	private Long daifaSellerId;
	/***/
	private Long dfGroupId;
	/***/
	private String daifaWorker;
	/***/
	private String password;
	/***/
	private String userName;
	/***/
	private String phone;
	/**类别@1拿货人2退货人3换货人4库管员*/
	private Integer workType;
	/**支付宝账户*/
	private String payBaoAccount;
	/**工作用户ID*/
	private Long workerId;
	/**角色ID*/
	private Long roleId;
	/**支付账户ID*/
	private Long accountId;
	/**状态@1可用2停用*/
	private Integer useStatus;
	/***/
	private String remark1;
	/***/
	private String remark2;
	 
	 //*************************get/set*****************************
    	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public Long getDaifaWorkerId() {
        return daifaWorkerId;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setDaifaWorkerId(Long daifaWorkerId) {
        this.daifaWorkerId = daifaWorkerId;
    }
	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public Long getDaifaSellerId() {
        return daifaSellerId;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setDaifaSellerId(Long daifaSellerId) {
        this.daifaSellerId = daifaSellerId;
    }
	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public Long getDfGroupId() {
        return dfGroupId;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setDfGroupId(Long dfGroupId) {
        this.dfGroupId = dfGroupId;
    }
	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public String getDaifaWorker() {
        return daifaWorker;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setDaifaWorker(String daifaWorker) {
        this.daifaWorker = daifaWorker;
    }
	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public String getPassword() {
        return password;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setPassword(String password) {
        this.password = password;
    }
	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public String getUserName() {
        return userName;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setUserName(String userName) {
        this.userName = userName;
    }
	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public String getPhone() {
        return phone;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setPhone(String phone) {
        this.phone = phone;
    }
	/**
  	* 
	*get方法
  	*类别@1拿货人2退货人3换货人4库管员
 	*自动生成
  	*/
    public Integer getWorkType() {
        return workType;
    }

    /**
  	* 
  	*set方法
	*类别@1拿货人2退货人3换货人4库管员
 	*自动生成
  	*/
    public void setWorkType(Integer workType) {
        this.workType = workType;
    }
	/**
  	* 
	*get方法
  	*支付宝账户
 	*自动生成
  	*/
    public String getPayBaoAccount() {
        return payBaoAccount;
    }

    /**
  	* 
  	*set方法
	*支付宝账户
 	*自动生成
  	*/
    public void setPayBaoAccount(String payBaoAccount) {
        this.payBaoAccount = payBaoAccount;
    }
	/**
  	* 
	*get方法
  	*工作用户ID
 	*自动生成
  	*/
    public Long getWorkerId() {
        return workerId;
    }

    /**
  	* 
  	*set方法
	*工作用户ID
 	*自动生成
  	*/
    public void setWorkerId(Long workerId) {
        this.workerId = workerId;
    }
	/**
  	* 
	*get方法
  	*角色ID
 	*自动生成
  	*/
    public Long getRoleId() {
        return roleId;
    }

    /**
  	* 
  	*set方法
	*角色ID
 	*自动生成
  	*/
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
	/**
  	* 
	*get方法
  	*支付账户ID
 	*自动生成
  	*/
    public Long getAccountId() {
        return accountId;
    }

    /**
  	* 
  	*set方法
	*支付账户ID
 	*自动生成
  	*/
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
	/**
  	* 
	*get方法
  	*状态@1可用2停用
 	*自动生成
  	*/
    public Integer getUseStatus() {
        return useStatus;
    }

    /**
  	* 
  	*set方法
	*状态@1可用2停用
 	*自动生成
  	*/
    public void setUseStatus(Integer useStatus) {
        this.useStatus = useStatus;
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
