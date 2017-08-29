package com.opentae.data.daifa.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 *==========================================================
 *TODO
 *@类编号：
 *@类名称：DaifaSeller.java
 *@文件路径：com.opentae.data.daifa.beans.DaifaSeller
 *@内容摘要：
 *@编码作者：自动生成
 *@完成日期：
 *@Date2017-08-09 04:19:23
 *@comments:
 *
 *=========================================================
 */
public class DaifaSeller implements Serializable {
	
	/***/
	@Id
@GeneratedValue(generator="JDBC")
	private Long dfSellerId;
	/***/
	private String name;
	/***/
	private String imWw;
	/***/
	private String email;
	/***/
	private java.util.Date lastLogin;
	/***/
	private String telephone;
	/***/
	private String address;
	/**0不可用 1可用*/
	private Integer status;
	/***/
	private String webSite;
	/***/
	private Long buycityId;
	/***/
	private String imQq;
	/***/
	private java.util.Date lastDoTime;
	/***/
	private java.util.Date createTime;
	/***/
	private String remark1;
	/***/
	private String remark2;
	/**支付宝账号*/
	private String alipayAccount;
	/**微信账号*/
	private String weixinAccount;
	 
	 //*************************get/set*****************************
    	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public Long getDfSellerId() {
        return dfSellerId;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setDfSellerId(Long dfSellerId) {
        this.dfSellerId = dfSellerId;
    }
	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public String getName() {
        return name;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setName(String name) {
        this.name = name;
    }
	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public String getImWw() {
        return imWw;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setImWw(String imWw) {
        this.imWw = imWw;
    }
	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public String getEmail() {
        return email;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setEmail(String email) {
        this.email = email;
    }
	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public java.util.Date getLastLogin() {
        return lastLogin;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setLastLogin(java.util.Date lastLogin) {
        this.lastLogin = lastLogin;
    }
	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public String getTelephone() {
        return telephone;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public String getAddress() {
        return address;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setAddress(String address) {
        this.address = address;
    }
	/**
  	* 
	*get方法
  	*0不可用 1可用
 	*自动生成
  	*/
    public Integer getStatus() {
        return status;
    }

    /**
  	* 
  	*set方法
	*0不可用 1可用
 	*自动生成
  	*/
    public void setStatus(Integer status) {
        this.status = status;
    }
	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public String getWebSite() {
        return webSite;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }
	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public Long getBuycityId() {
        return buycityId;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setBuycityId(Long buycityId) {
        this.buycityId = buycityId;
    }
	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public String getImQq() {
        return imQq;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setImQq(String imQq) {
        this.imQq = imQq;
    }
	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public java.util.Date getLastDoTime() {
        return lastDoTime;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setLastDoTime(java.util.Date lastDoTime) {
        this.lastDoTime = lastDoTime;
    }
	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public java.util.Date getCreateTime() {
        return createTime;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
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
	/**
  	* 
	*get方法
  	*支付宝账号
 	*自动生成
  	*/
    public String getAlipayAccount() {
        return alipayAccount;
    }

    /**
  	* 
  	*set方法
	*支付宝账号
 	*自动生成
  	*/
    public void setAlipayAccount(String alipayAccount) {
        this.alipayAccount = alipayAccount;
    }
	/**
  	* 
	*get方法
  	*微信账号
 	*自动生成
  	*/
    public String getWeixinAccount() {
        return weixinAccount;
    }

    /**
  	* 
  	*set方法
	*微信账号
 	*自动生成
  	*/
    public void setWeixinAccount(String weixinAccount) {
        this.weixinAccount = weixinAccount;
    }
}
