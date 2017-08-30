package com.opentae.data.daifa.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 *==========================================================
 *TODO
 *@类编号：
 *@类名称：DaifaSend.java
 *@文件路径：com.opentae.data.daifa.beans.DaifaSend
 *@内容摘要：
 *@编码作者：自动生成
 *@完成日期：
 *@Date2017-08-09 04:19:28
 *@comments:
 *
 *=========================================================
 */
public class DaifaSend implements Serializable {
	
	/**ID*/
	@Id
@GeneratedValue(generator="JDBC")
	private Long sendId;
	/**交易Id*/
	private Long dfTradeId;
	/**代发ID*/
	private Long sellerId;
	/**已发编码@按天的已发编码:fh{日期},日期格式为yyyyMMdd*/
	private String daifaSendCode;
	/**发货状态@0未发货2已经出库发货*/
	private Integer sendStatus;
	/**创建日期@ YYYYMMDD*/
	private String createDate;
	/**创建时间*/
	private java.util.Date createTime;
	/**发货日期@ YYYYMMDD*/
	private String sendDate;
	/**发货时间*/
	private java.util.Date sendTime;
	/**总钱数@单位元*/
	private String money;
	/**买家ID*/
	private Long buyerId;
	/**快递ID*/
	private Long expressId;
	/**快递名*/
	private String expressName;
	/**快递单号*/
	private String expressCode;
	/**快递费*/
	private String expressFee;
	/**收件人省*/
	private String receiverState;
	/**收件人详细地址*/
	private String receiverAddress;
	/**收件人姓名*/
	private String receiverName;
	/**收件人邮编*/
	private String receiverZip;
	/**收件人手机号*/
	private String receiverPhone;
	/**买家留言*/
	private String buyerRemark;
	/**打印状态@0未打印1已打印*/
	private Integer printStatus;
	/**三段码*/
	private String markDestination;
	/**集包地*/
	private String packageName;
	/**备用1*/
	private String remark1;
	/**备用2*/
	private String remark2;
	/**淘宝账户的昵称*/
	private String taobaoUserNick;
	/**淘宝订单号tid*/
	private Long taobaoTid;
	/**买家姓名*/
	private String buyerName;
	/**买家电话*/
	private String buyerTelephone;
	/**买家QQ*/
	private String buyerQq;
	/**买家旺旺*/
	private String buyerWw;
	 
	 //*************************get/set*****************************
    	/**
  	* 
	*get方法
  	*ID
 	*自动生成
  	*/
    public Long getSendId() {
        return sendId;
    }

    /**
  	* 
  	*set方法
	*ID
 	*自动生成
  	*/
    public void setSendId(Long sendId) {
        this.sendId = sendId;
    }
	/**
  	* 
	*get方法
  	*交易Id
 	*自动生成
  	*/
    public Long getDfTradeId() {
        return dfTradeId;
    }

    /**
  	* 
  	*set方法
	*交易Id
 	*自动生成
  	*/
    public void setDfTradeId(Long dfTradeId) {
        this.dfTradeId = dfTradeId;
    }
	/**
  	* 
	*get方法
  	*代发ID
 	*自动生成
  	*/
    public Long getSellerId() {
        return sellerId;
    }

    /**
  	* 
  	*set方法
	*代发ID
 	*自动生成
  	*/
    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }
	/**
  	* 
	*get方法
  	*已发编码@按天的已发编码:fh{日期},日期格式为yyyyMMdd
 	*自动生成
  	*/
    public String getDaifaSendCode() {
        return daifaSendCode;
    }

    /**
  	* 
  	*set方法
	*已发编码@按天的已发编码:fh{日期},日期格式为yyyyMMdd
 	*自动生成
  	*/
    public void setDaifaSendCode(String daifaSendCode) {
        this.daifaSendCode = daifaSendCode;
    }
	/**
  	* 
	*get方法
  	*发货状态@0未发货2已经出库发货
 	*自动生成
  	*/
    public Integer getSendStatus() {
        return sendStatus;
    }

    /**
  	* 
  	*set方法
	*发货状态@0未发货2已经出库发货
 	*自动生成
  	*/
    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }
	/**
  	* 
	*get方法
  	*创建日期@ YYYYMMDD
 	*自动生成
  	*/
    public String getCreateDate() {
        return createDate;
    }

    /**
  	* 
  	*set方法
	*创建日期@ YYYYMMDD
 	*自动生成
  	*/
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
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
  	*发货日期@ YYYYMMDD
 	*自动生成
  	*/
    public String getSendDate() {
        return sendDate;
    }

    /**
  	* 
  	*set方法
	*发货日期@ YYYYMMDD
 	*自动生成
  	*/
    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }
	/**
  	* 
	*get方法
  	*发货时间
 	*自动生成
  	*/
    public java.util.Date getSendTime() {
        return sendTime;
    }

    /**
  	* 
  	*set方法
	*发货时间
 	*自动生成
  	*/
    public void setSendTime(java.util.Date sendTime) {
        this.sendTime = sendTime;
    }
	/**
  	* 
	*get方法
  	*总钱数@单位元
 	*自动生成
  	*/
    public String getMoney() {
        return money;
    }

    /**
  	* 
  	*set方法
	*总钱数@单位元
 	*自动生成
  	*/
    public void setMoney(String money) {
        this.money = money;
    }
	/**
  	* 
	*get方法
  	*买家ID
 	*自动生成
  	*/
    public Long getBuyerId() {
        return buyerId;
    }

    /**
  	* 
  	*set方法
	*买家ID
 	*自动生成
  	*/
    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }
	/**
  	* 
	*get方法
  	*快递ID
 	*自动生成
  	*/
    public Long getExpressId() {
        return expressId;
    }

    /**
  	* 
  	*set方法
	*快递ID
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
    public String getExpressName() {
        return expressName;
    }

    /**
  	* 
  	*set方法
	*快递名
 	*自动生成
  	*/
    public void setExpressName(String expressName) {
        this.expressName = expressName;
    }
	/**
  	* 
	*get方法
  	*快递单号
 	*自动生成
  	*/
    public String getExpressCode() {
        return expressCode;
    }

    /**
  	* 
  	*set方法
	*快递单号
 	*自动生成
  	*/
    public void setExpressCode(String expressCode) {
        this.expressCode = expressCode;
    }
	/**
  	* 
	*get方法
  	*快递费
 	*自动生成
  	*/
    public String getExpressFee() {
        return expressFee;
    }

    /**
  	* 
  	*set方法
	*快递费
 	*自动生成
  	*/
    public void setExpressFee(String expressFee) {
        this.expressFee = expressFee;
    }
	/**
  	* 
	*get方法
  	*收件人省
 	*自动生成
  	*/
    public String getReceiverState() {
        return receiverState;
    }

    /**
  	* 
  	*set方法
	*收件人省
 	*自动生成
  	*/
    public void setReceiverState(String receiverState) {
        this.receiverState = receiverState;
    }
	/**
  	* 
	*get方法
  	*收件人详细地址
 	*自动生成
  	*/
    public String getReceiverAddress() {
        return receiverAddress;
    }

    /**
  	* 
  	*set方法
	*收件人详细地址
 	*自动生成
  	*/
    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }
	/**
  	* 
	*get方法
  	*收件人姓名
 	*自动生成
  	*/
    public String getReceiverName() {
        return receiverName;
    }

    /**
  	* 
  	*set方法
	*收件人姓名
 	*自动生成
  	*/
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }
	/**
  	* 
	*get方法
  	*收件人邮编
 	*自动生成
  	*/
    public String getReceiverZip() {
        return receiverZip;
    }

    /**
  	* 
  	*set方法
	*收件人邮编
 	*自动生成
  	*/
    public void setReceiverZip(String receiverZip) {
        this.receiverZip = receiverZip;
    }
	/**
  	* 
	*get方法
  	*收件人手机号
 	*自动生成
  	*/
    public String getReceiverPhone() {
        return receiverPhone;
    }

    /**
  	* 
  	*set方法
	*收件人手机号
 	*自动生成
  	*/
    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }
	/**
  	* 
	*get方法
  	*买家留言
 	*自动生成
  	*/
    public String getBuyerRemark() {
        return buyerRemark;
    }

    /**
  	* 
  	*set方法
	*买家留言
 	*自动生成
  	*/
    public void setBuyerRemark(String buyerRemark) {
        this.buyerRemark = buyerRemark;
    }
	/**
  	* 
	*get方法
  	*打印状态@0未打印1已打印
 	*自动生成
  	*/
    public Integer getPrintStatus() {
        return printStatus;
    }

    /**
  	* 
  	*set方法
	*打印状态@0未打印1已打印
 	*自动生成
  	*/
    public void setPrintStatus(Integer printStatus) {
        this.printStatus = printStatus;
    }
	/**
  	* 
	*get方法
  	*三段码
 	*自动生成
  	*/
    public String getMarkDestination() {
        return markDestination;
    }

    /**
  	* 
  	*set方法
	*三段码
 	*自动生成
  	*/
    public void setMarkDestination(String markDestination) {
        this.markDestination = markDestination;
    }
	/**
  	* 
	*get方法
  	*集包地
 	*自动生成
  	*/
    public String getPackageName() {
        return packageName;
    }

    /**
  	* 
  	*set方法
	*集包地
 	*自动生成
  	*/
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
	/**
  	* 
	*get方法
  	*备用1
 	*自动生成
  	*/
    public String getRemark1() {
        return remark1;
    }

    /**
  	* 
  	*set方法
	*备用1
 	*自动生成
  	*/
    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }
	/**
  	* 
	*get方法
  	*备用2
 	*自动生成
  	*/
    public String getRemark2() {
        return remark2;
    }

    /**
  	* 
  	*set方法
	*备用2
 	*自动生成
  	*/
    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }
	/**
  	* 
	*get方法
  	*淘宝账户的昵称
 	*自动生成
  	*/
    public String getTaobaoUserNick() {
        return taobaoUserNick;
    }

    /**
  	* 
  	*set方法
	*淘宝账户的昵称
 	*自动生成
  	*/
    public void setTaobaoUserNick(String taobaoUserNick) {
        this.taobaoUserNick = taobaoUserNick;
    }
	/**
  	* 
	*get方法
  	*淘宝订单号tid
 	*自动生成
  	*/
    public Long getTaobaoTid() {
        return taobaoTid;
    }

    /**
  	* 
  	*set方法
	*淘宝订单号tid
 	*自动生成
  	*/
    public void setTaobaoTid(Long taobaoTid) {
        this.taobaoTid = taobaoTid;
    }
	/**
  	* 
	*get方法
  	*买家姓名
 	*自动生成
  	*/
    public String getBuyerName() {
        return buyerName;
    }

    /**
  	* 
  	*set方法
	*买家姓名
 	*自动生成
  	*/
    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }
	/**
  	* 
	*get方法
  	*买家电话
 	*自动生成
  	*/
    public String getBuyerTelephone() {
        return buyerTelephone;
    }

    /**
  	* 
  	*set方法
	*买家电话
 	*自动生成
  	*/
    public void setBuyerTelephone(String buyerTelephone) {
        this.buyerTelephone = buyerTelephone;
    }
	/**
  	* 
	*get方法
  	*买家QQ
 	*自动生成
  	*/
    public String getBuyerQq() {
        return buyerQq;
    }

    /**
  	* 
  	*set方法
	*买家QQ
 	*自动生成
  	*/
    public void setBuyerQq(String buyerQq) {
        this.buyerQq = buyerQq;
    }
	/**
  	* 
	*get方法
  	*买家旺旺
 	*自动生成
  	*/
    public String getBuyerWw() {
        return buyerWw;
    }

    /**
  	* 
  	*set方法
	*买家旺旺
 	*自动生成
  	*/
    public void setBuyerWw(String buyerWw) {
        this.buyerWw = buyerWw;
    }
}
