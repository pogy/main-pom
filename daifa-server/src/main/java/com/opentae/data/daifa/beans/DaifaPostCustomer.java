package com.opentae.data.daifa.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 *==========================================================
 *TODO
 *@类编号：
 *@类名称：DaifaPostCustomer.java
 *@文件路径：com.opentae.data.daifa.beans.DaifaPostCustomer
 *@内容摘要：
 *@编码作者：自动生成
 *@完成日期：
 *@Date2017-08-10 11:23:52
 *@comments:
 *
 *=========================================================
 */
public class DaifaPostCustomer implements Serializable {
	
	/***/
	@Id
@GeneratedValue(generator="JDBC")
	private Long postCustomerId;
	/**代发ID*/
	private Long dfSellerId;
	/**0:无效,1:有效*/
	private Integer useStatus;
	/**快递ID,暂定为daifa_seller_post的dsp_id*/
	private Long expressId;
	/**快递名*/
	private String express;
	/**快递公司简称代码*/
	private String expressCompanyCode;
	/**是否需要电子面单账户,1:需要,0:不需要*/
	private Integer isNeedCustomer;
	/**电子面单账户名*/
	private String customerName;
	/**电子面单账户密码,和month_code至少有一个,具体是哪个,参照文档*/
	private String customerPwd;
	/**电子面单账户秘钥,和customer_pwd至少有一个,具体是哪个,参照文档*/
	private String monthCode;
	/**快递网点名,是否需要参照文档*/
	private String sendSite;
	/**快递单号*/
	private String logisticCode;
	 
	 //*************************get/set*****************************
    	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public Long getPostCustomerId() {
        return postCustomerId;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setPostCustomerId(Long postCustomerId) {
        this.postCustomerId = postCustomerId;
    }
	/**
  	* 
	*get方法
  	*代发ID
 	*自动生成
  	*/
    public Long getDfSellerId() {
        return dfSellerId;
    }

    /**
  	* 
  	*set方法
	*代发ID
 	*自动生成
  	*/
    public void setDfSellerId(Long dfSellerId) {
        this.dfSellerId = dfSellerId;
    }
	/**
  	* 
	*get方法
  	*0:无效,1:有效
 	*自动生成
  	*/
    public Integer getUseStatus() {
        return useStatus;
    }

    /**
  	* 
  	*set方法
	*0:无效,1:有效
 	*自动生成
  	*/
    public void setUseStatus(Integer useStatus) {
        this.useStatus = useStatus;
    }
	/**
  	* 
	*get方法
  	*快递ID,暂定为daifa_seller_post的dsp_id
 	*自动生成
  	*/
    public Long getExpressId() {
        return expressId;
    }

    /**
  	* 
  	*set方法
	*快递ID,暂定为daifa_seller_post的dsp_id
 	*自动生成
  	*/
    public void setExpressId(Long expressId) {
        this.expressId = expressId;
    }
	/**
  	* 
	*get方法
  	*快递名
 	*自动生成
  	*/
    public String getExpress() {
        return express;
    }

    /**
  	* 
  	*set方法
	*快递名
 	*自动生成
  	*/
    public void setExpress(String express) {
        this.express = express;
    }
	/**
  	* 
	*get方法
  	*快递公司简称代码
 	*自动生成
  	*/
    public String getExpressCompanyCode() {
        return expressCompanyCode;
    }

    /**
  	* 
  	*set方法
	*快递公司简称代码
 	*自动生成
  	*/
    public void setExpressCompanyCode(String expressCompanyCode) {
        this.expressCompanyCode = expressCompanyCode;
    }
	/**
  	* 
	*get方法
  	*是否需要电子面单账户,1:需要,0:不需要
 	*自动生成
  	*/
    public Integer getIsNeedCustomer() {
        return isNeedCustomer;
    }

    /**
  	* 
  	*set方法
	*是否需要电子面单账户,1:需要,0:不需要
 	*自动生成
  	*/
    public void setIsNeedCustomer(Integer isNeedCustomer) {
        this.isNeedCustomer = isNeedCustomer;
    }
	/**
  	* 
	*get方法
  	*电子面单账户名
 	*自动生成
  	*/
    public String getCustomerName() {
        return customerName;
    }

    /**
  	* 
  	*set方法
	*电子面单账户名
 	*自动生成
  	*/
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
	/**
  	* 
	*get方法
  	*电子面单账户密码,和month_code至少有一个,具体是哪个,参照文档
 	*自动生成
  	*/
    public String getCustomerPwd() {
        return customerPwd;
    }

    /**
  	* 
  	*set方法
	*电子面单账户密码,和month_code至少有一个,具体是哪个,参照文档
 	*自动生成
  	*/
    public void setCustomerPwd(String customerPwd) {
        this.customerPwd = customerPwd;
    }
	/**
  	* 
	*get方法
  	*电子面单账户秘钥,和customer_pwd至少有一个,具体是哪个,参照文档
 	*自动生成
  	*/
    public String getMonthCode() {
        return monthCode;
    }

    /**
  	* 
  	*set方法
	*电子面单账户秘钥,和customer_pwd至少有一个,具体是哪个,参照文档
 	*自动生成
  	*/
    public void setMonthCode(String monthCode) {
        this.monthCode = monthCode;
    }
	/**
  	* 
	*get方法
  	*快递网点名,是否需要参照文档
 	*自动生成
  	*/
    public String getSendSite() {
        return sendSite;
    }

    /**
  	* 
  	*set方法
	*快递网点名,是否需要参照文档
 	*自动生成
  	*/
    public void setSendSite(String sendSite) {
        this.sendSite = sendSite;
    }
	/**
  	* 
	*get方法
  	*快递单号
 	*自动生成
  	*/
    public String getLogisticCode() {
        return logisticCode;
    }

    /**
  	* 
  	*set方法
	*快递单号
 	*自动生成
  	*/
    public void setLogisticCode(String logisticCode) {
        this.logisticCode = logisticCode;
    }
}
