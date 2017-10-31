package com.opentae.data.daifa.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class DaifaAfterSale implements Serializable {
    /**
     * ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long afterSaleId;

    /**
     * 交易Id
     */
	private Long dfTradeId;

    /**
     * 
     */
	private String tradeCode;

    /**
     * 代发ID
     */
	private Long sellerId;

    /**
     * 售后创建日期@ YYYYMMDD
     */
	private String createDate;

    /**
     * 售后创建时间
     */
	private Date createTime;

    /**
     * 总钱数@单位元
     */
	private String money;

    /**
     * 买家ID
     */
	private Integer buyerId;

    /**
     * 买家姓名
     */
	private String buyerName;

    /**
     * 买家电话
     */
	private String buyerTelephone;

    /**
     * 买家QQ
     */
	private String buyerQq;

    /**
     * 买家旺旺
     */
	private String buyerWw;

    /**
     * 收件人省份
     */
	private String receiverState;

    /**
     * 收件人详细地址
     */
	private String receiverAddress;

    /**
     * 收件人姓名
     */
	private String receiverName;

    /**
     * 收件人邮编
     */
	private String receiverZip;

    /**
     * 收件人手机号
     */
	private String receiverMobile;

    /**
     * 买家留言
     */
	private String buyerRemark;

    /**
     * 收货人QQ
     */
	private String receiverQq;

    /**
     * 备用1
     */
	private String remark1;

    /**
     * 备用2
     */
	private String remark2;

    /**
     * 售后备注
     */
	private String remark;

	public void setAfterSaleId(Long afterSaleId) {
		this.afterSaleId = afterSaleId;
	}

	public Long getAfterSaleId() {
		return this.afterSaleId;
	}

	public void setDfTradeId(Long dfTradeId) {
		this.dfTradeId = dfTradeId;
	}

	public Long getDfTradeId() {
		return this.dfTradeId;
	}

	public void setTradeCode(String tradeCode) {
		this.tradeCode = tradeCode;
	}

	public String getTradeCode() {
		return this.tradeCode;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public Long getSellerId() {
		return this.sellerId;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getCreateDate() {
		return this.createDate;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getMoney() {
		return this.money;
	}

	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}

	public Integer getBuyerId() {
		return this.buyerId;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getBuyerName() {
		return this.buyerName;
	}

	public void setBuyerTelephone(String buyerTelephone) {
		this.buyerTelephone = buyerTelephone;
	}

	public String getBuyerTelephone() {
		return this.buyerTelephone;
	}

	public void setBuyerQq(String buyerQq) {
		this.buyerQq = buyerQq;
	}

	public String getBuyerQq() {
		return this.buyerQq;
	}

	public void setBuyerWw(String buyerWw) {
		this.buyerWw = buyerWw;
	}

	public String getBuyerWw() {
		return this.buyerWw;
	}

	public void setReceiverState(String receiverState) {
		this.receiverState = receiverState;
	}

	public String getReceiverState() {
		return this.receiverState;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public String getReceiverAddress() {
		return this.receiverAddress;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverName() {
		return this.receiverName;
	}

	public void setReceiverZip(String receiverZip) {
		this.receiverZip = receiverZip;
	}

	public String getReceiverZip() {
		return this.receiverZip;
	}

	public void setReceiverMobile(String receiverMobile) {
		this.receiverMobile = receiverMobile;
	}

	public String getReceiverMobile() {
		return this.receiverMobile;
	}

	public void setBuyerRemark(String buyerRemark) {
		this.buyerRemark = buyerRemark;
	}

	public String getBuyerRemark() {
		return this.buyerRemark;
	}

	public void setReceiverQq(String receiverQq) {
		this.receiverQq = receiverQq;
	}

	public String getReceiverQq() {
		return this.receiverQq;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public String getRemark1() {
		return this.remark1;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	public String getRemark2() {
		return this.remark2;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return this.remark;
	}

}