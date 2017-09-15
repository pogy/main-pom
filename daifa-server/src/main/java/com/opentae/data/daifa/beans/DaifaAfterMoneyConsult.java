package com.opentae.data.daifa.beans;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Transient;
import java.io.Serializable;
/**
 *==========================================================
 *TODO
 *@类编号：
 *@类名称：DaifaAfterMoneyConsult.java
 *@文件路径：com.opentae.data.songhuoyi.beans.DaifaAfterMoneyConsult
 *@内容摘要：
 *@编码作者：自动生成
 *@完成日期：
 *@Date2017-09-15 03:55:15
 *@comments:
 *
 *=========================================================
 */
public class DaifaAfterMoneyConsult implements Serializable{
	
	/**退回的协商金处理ID*/
	@Id
@GeneratedValue(generator="JDBC")
	private Long afterConsultId;
	/***/
	private Long afterSaleSubId;
	/**退货ID*/
	private Long refundId;
	/**创建时间*/
	private java.util.Date createTime;
	/**协商类型@1客服输入2客户拒绝*/
	private Integer consultType;
	/**协商金额@以元为单位*/
	private String consultMoney;
	/**最后的操作时间@一般为客户操作*/
	private java.util.Date lastDoTime;
	/**第几次协商*/
	private Integer consultBatch;
	/**备注*/
	private String remark1;
	/**备用*/
	private String remark2;
	 
	 //*************************get/set*****************************
    	/**
  	* 
	*get方法
  	*退回的协商金处理ID
 	*自动生成
  	*/
    public Long getAfterConsultId() {
        return afterConsultId;
    }

    /**
  	* 
  	*set方法
	*退回的协商金处理ID
 	*自动生成
  	*/
    public void setAfterConsultId(Long afterConsultId) {
        this.afterConsultId = afterConsultId;
    }
	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public Long getAfterSaleSubId() {
        return afterSaleSubId;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setAfterSaleSubId(Long afterSaleSubId) {
        this.afterSaleSubId = afterSaleSubId;
    }
	/**
  	* 
	*get方法
  	*退货ID
 	*自动生成
  	*/
    public Long getRefundId() {
        return refundId;
    }

    /**
  	* 
  	*set方法
	*退货ID
 	*自动生成
  	*/
    public void setRefundId(Long refundId) {
        this.refundId = refundId;
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
  	*协商类型@1客服输入2客户拒绝
 	*自动生成
  	*/
    public Integer getConsultType() {
        return consultType;
    }

    /**
  	* 
  	*set方法
	*协商类型@1客服输入2客户拒绝
 	*自动生成
  	*/
    public void setConsultType(Integer consultType) {
        this.consultType = consultType;
    }
	/**
  	* 
	*get方法
  	*协商金额@以元为单位
 	*自动生成
  	*/
    public String getConsultMoney() {
        return consultMoney;
    }

    /**
  	* 
  	*set方法
	*协商金额@以元为单位
 	*自动生成
  	*/
    public void setConsultMoney(String consultMoney) {
        this.consultMoney = consultMoney;
    }
	/**
  	* 
	*get方法
  	*最后的操作时间@一般为客户操作
 	*自动生成
  	*/
    public java.util.Date getLastDoTime() {
        return lastDoTime;
    }

    /**
  	* 
  	*set方法
	*最后的操作时间@一般为客户操作
 	*自动生成
  	*/
    public void setLastDoTime(java.util.Date lastDoTime) {
        this.lastDoTime = lastDoTime;
    }
	/**
  	* 
	*get方法
  	*第几次协商
 	*自动生成
  	*/
    public Integer getConsultBatch() {
        return consultBatch;
    }

    /**
  	* 
  	*set方法
	*第几次协商
 	*自动生成
  	*/
    public void setConsultBatch(Integer consultBatch) {
        this.consultBatch = consultBatch;
    }
	/**
  	* 
	*get方法
  	*备注
 	*自动生成
  	*/
    public String getRemark1() {
        return remark1;
    }

    /**
  	* 
  	*set方法
	*备注
 	*自动生成
  	*/
    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }
	/**
  	* 
	*get方法
  	*备用
 	*自动生成
  	*/
    public String getRemark2() {
        return remark2;
    }

    /**
  	* 
  	*set方法
	*备用
 	*自动生成
  	*/
    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }
}
