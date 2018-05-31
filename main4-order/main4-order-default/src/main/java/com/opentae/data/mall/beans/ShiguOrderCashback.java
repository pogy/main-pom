package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class ShiguOrderCashback implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long cId;

    /**
     * 主订单id
     */
	private Long oId;

    /**
     * 返现金额
     */
	private Long cashback;

    /**
     * 创建时间
     */
	private Date createTime;

    /**
     * 完成时间
     */
	private Date endTime;

	public void setCId(Long cId) {
		this.cId = cId;
	}

	public Long getCId() {
		return this.cId;
	}

	public void setOId(Long oId) {
		this.oId = oId;
	}

	public Long getOId() {
		return this.oId;
	}

	public void setCashback(Long cashback) {
		this.cashback = cashback;
	}

	public Long getCashback() {
		return this.cashback;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getEndTime() {
		return this.endTime;
	}

}