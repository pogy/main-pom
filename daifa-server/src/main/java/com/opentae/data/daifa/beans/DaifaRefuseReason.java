package com.opentae.data.daifa.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class DaifaRefuseReason implements Serializable {
    /**
     * 原因ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long dealReasonId;

    /**
     * 原因类型@1售后发起的拒绝的原因
     */
	private Integer dealReasonType;

    /**
     * 原因
     */
	private String dealReason;

    /**
     * 
     */
	private Date createTime;

    /**
     * 状态@1可用2不可用
     */
	private Integer useStatus;

	public void setDealReasonId(Long dealReasonId) {
		this.dealReasonId = dealReasonId;
	}

	public Long getDealReasonId() {
		return this.dealReasonId;
	}

	public void setDealReasonType(Integer dealReasonType) {
		this.dealReasonType = dealReasonType;
	}

	public Integer getDealReasonType() {
		return this.dealReasonType;
	}

	public void setDealReason(String dealReason) {
		this.dealReason = dealReason;
	}

	public String getDealReason() {
		return this.dealReason;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setUseStatus(Integer useStatus) {
		this.useStatus = useStatus;
	}

	public Integer getUseStatus() {
		return this.useStatus;
	}

}