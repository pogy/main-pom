package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class ItemRefundLog implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long refundLogId;

    /**
     * 创建时间
     */
	private Date createTime;

    /**
     * 
     */
	private Long refundId;

    /**
     * 信息
     */
	private String msg;

    /**
     * 1买家，2卖家
     */
	private Boolean imBuyer;

    /**
     * 变化前的状态
     */
	private Integer fromStatus;

    /**
     * 变化后的状态
     */
	private Integer toStatus;

	public void setRefundLogId(Long refundLogId) {
		this.refundLogId = refundLogId;
	}

	public Long getRefundLogId() {
		return this.refundLogId;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setRefundId(Long refundId) {
		this.refundId = refundId;
	}

	public Long getRefundId() {
		return this.refundId;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return this.msg;
	}

	public void setImBuyer(Boolean imBuyer) {
		this.imBuyer = imBuyer;
	}

	public Boolean getImBuyer() {
		return this.imBuyer;
	}

	public void setFromStatus(Integer fromStatus) {
		this.fromStatus = fromStatus;
	}

	public Integer getFromStatus() {
		return this.fromStatus;
	}

	public void setToStatus(Integer toStatus) {
		this.toStatus = toStatus;
	}

	public Integer getToStatus() {
		return this.toStatus;
	}

}