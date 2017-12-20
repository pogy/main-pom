package com.opentae.data.daifa.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class DaifaAfterReceiveExpresStock implements Serializable {
    /**
     * 收到货的ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Integer receivedExpressId;

    /**
     * 收到货的快递名
     */
	private String receivedExpressName;

    /**
     * 收到的快递单号
     */
	private String receivedExpressCode;

    /**
     * 创建时间
     */
	private Date createTime;

    /**
     * 发货人手机号
     */
	private String sendPhone;

    /**
     * 关联状态@0没有关联1已关联
     */
	private Integer relevanceStatus;

    /**
     * 退换ID
     */
	private Long refundId;

    /**
     * 代发交易ID
     */
	private Long dfTradeId;

    /**
     * 订单编号
     */
	private String tradeCode;

    /**
     * 代发子单ID
     */
	private Long dfOrderId;

    /**
     * 订单编号
     */
	private String orderCode;

    /**
     * 折单编号
     */
	private String orderPartitionId;

    /**
     * 入库后存储的货架
     */
	private String stockLocation;

    /**
     * 
     */
	private String packageRemark;

	public void setReceivedExpressId(Integer receivedExpressId) {
		this.receivedExpressId = receivedExpressId;
	}

	public Integer getReceivedExpressId() {
		return this.receivedExpressId;
	}

	public void setReceivedExpressName(String receivedExpressName) {
		this.receivedExpressName = receivedExpressName;
	}

	public String getReceivedExpressName() {
		return this.receivedExpressName;
	}

	public void setReceivedExpressCode(String receivedExpressCode) {
		this.receivedExpressCode = receivedExpressCode;
	}

	public String getReceivedExpressCode() {
		return this.receivedExpressCode;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setSendPhone(String sendPhone) {
		this.sendPhone = sendPhone;
	}

	public String getSendPhone() {
		return this.sendPhone;
	}

	public void setRelevanceStatus(Integer relevanceStatus) {
		this.relevanceStatus = relevanceStatus;
	}

	public Integer getRelevanceStatus() {
		return this.relevanceStatus;
	}

	public void setRefundId(Long refundId) {
		this.refundId = refundId;
	}

	public Long getRefundId() {
		return this.refundId;
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

	public void setDfOrderId(Long dfOrderId) {
		this.dfOrderId = dfOrderId;
	}

	public Long getDfOrderId() {
		return this.dfOrderId;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getOrderCode() {
		return this.orderCode;
	}

	public void setOrderPartitionId(String orderPartitionId) {
		this.orderPartitionId = orderPartitionId;
	}

	public String getOrderPartitionId() {
		return this.orderPartitionId;
	}

	public void setStockLocation(String stockLocation) {
		this.stockLocation = stockLocation;
	}

	public String getStockLocation() {
		return this.stockLocation;
	}

	public void setPackageRemark(String packageRemark) {
		this.packageRemark = packageRemark;
	}

	public String getPackageRemark() {
		return this.packageRemark;
	}

}