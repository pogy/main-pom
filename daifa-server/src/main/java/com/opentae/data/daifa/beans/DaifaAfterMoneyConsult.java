package com.opentae.data.daifa.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class DaifaAfterMoneyConsult implements Serializable {
    /**
     * 退回的协商金处理ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long afterConsultId;

    /**
     * 退货ID
     */
	private Long refundId;

    /**
     * 创建时间
     */
	private Date createTime;

    /**
     * 协商类型@1客服输入2客户拒绝
     */
	private Integer consultType;

    /**
     * 协商金额@以元为单位
     */
	private String consultMoney;

    /**
     * 最后的操作时间@一般为客户操作
     */
	private Date lastDoTime;

    /**
     * 第几次协商
     */
	private Integer consultBatch;

    /**
     * 备注
     */
	private String remark1;

    /**
     * 备用
     */
	private String remark2;

	public void setAfterConsultId(Long afterConsultId) {
		this.afterConsultId = afterConsultId;
	}

	public Long getAfterConsultId() {
		return this.afterConsultId;
	}


	public void setRefundId(Long refundId) {
		this.refundId = refundId;
	}

	public Long getRefundId() {
		return this.refundId;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setConsultType(Integer consultType) {
		this.consultType = consultType;
	}

	public Integer getConsultType() {
		return this.consultType;
	}

	public void setConsultMoney(String consultMoney) {
		this.consultMoney = consultMoney;
	}

	public String getConsultMoney() {
		return this.consultMoney;
	}

	public void setLastDoTime(Date lastDoTime) {
		this.lastDoTime = lastDoTime;
	}

	public Date getLastDoTime() {
		return this.lastDoTime;
	}

	public void setConsultBatch(Integer consultBatch) {
		this.consultBatch = consultBatch;
	}

	public Integer getConsultBatch() {
		return this.consultBatch;
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

}