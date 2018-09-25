package com.opentae.data.pays.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class PayXzbRecord implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long xzbRecordId;

    /**
     * 
     */
	private Long accountId;

    /**
     * 变化原因，1付款，2退款，3充值，4系统调整
     */
	private Integer type;

    /**
     * 备注
     */
	private String comments;

    /**
     * 以分为单位，变化钱数
     */
	private Long money;

    /**
     * 以分为单位，变化前
     */
	private Long fromMoney;

    /**
     * 变化后，以分为单位
     */
	private Long toMoney;

    /**
     * 创建时间
     */
	private Date createTime;

    /**
     * 外部订单编号
     */
	private Long payId;

    /**
     * 充值记录ID
     */
	private Long rechargeId;

	public void setXzbRecordId(Long xzbRecordId) {
		this.xzbRecordId = xzbRecordId;
	}

	public Long getXzbRecordId() {
		return this.xzbRecordId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Long getAccountId() {
		return this.accountId;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getType() {
		return this.type;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getComments() {
		return this.comments;
	}

	public void setMoney(Long money) {
		this.money = money;
	}

	public Long getMoney() {
		return this.money;
	}

	public void setFromMoney(Long fromMoney) {
		this.fromMoney = fromMoney;
	}

	public Long getFromMoney() {
		return this.fromMoney;
	}

	public void setToMoney(Long toMoney) {
		this.toMoney = toMoney;
	}

	public Long getToMoney() {
		return this.toMoney;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setPayId(Long payId) {
		this.payId = payId;
	}

	public Long getPayId() {
		return this.payId;
	}

	public void setRechargeId(Long rechargeId) {
		this.rechargeId = rechargeId;
	}

	public Long getRechargeId() {
		return this.rechargeId;
	}

}