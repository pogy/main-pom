package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ItemOrderSub implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private String soid;

    /**
     * 订单号
     */
	private String oid;

    /**
     * 产品ID
     */
	private String pid;

    /**
     * sku信息
     */
	private String skuId;

    /**
     * 件数
     */
	private String num;

    /**
     * 到货数量
     */
	private String distributionNum;

    /**
     * 应付总额
     */
	private String shouldPayMoney;

    /**
     * 实付
     */
	private String payMoney;

    /**
     * 实退
     */
	private String refundMoney;

    /**
     * 是否已发
     */
	private String send;

    /**
     * 是否退款
     */
	private String refund;

    /**
     * 备注
     */
	private String mark;

    /**
     * 交易信息ID
     */
	private String logisticsId;

	public void setSoid(String soid) {
		this.soid = soid;
	}

	public String getSoid() {
		return this.soid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getOid() {
		return this.oid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPid() {
		return this.pid;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public String getSkuId() {
		return this.skuId;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getNum() {
		return this.num;
	}

	public void setDistributionNum(String distributionNum) {
		this.distributionNum = distributionNum;
	}

	public String getDistributionNum() {
		return this.distributionNum;
	}

	public void setShouldPayMoney(String shouldPayMoney) {
		this.shouldPayMoney = shouldPayMoney;
	}

	public String getShouldPayMoney() {
		return this.shouldPayMoney;
	}

	public void setPayMoney(String payMoney) {
		this.payMoney = payMoney;
	}

	public String getPayMoney() {
		return this.payMoney;
	}

	public void setRefundMoney(String refundMoney) {
		this.refundMoney = refundMoney;
	}

	public String getRefundMoney() {
		return this.refundMoney;
	}

	public void setSend(String send) {
		this.send = send;
	}

	public String getSend() {
		return this.send;
	}

	public void setRefund(String refund) {
		this.refund = refund;
	}

	public String getRefund() {
		return this.refund;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getMark() {
		return this.mark;
	}

	public void setLogisticsId(String logisticsId) {
		this.logisticsId = logisticsId;
	}

	public String getLogisticsId() {
		return this.logisticsId;
	}

}