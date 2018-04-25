package com.opentae.photo.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class PhotoAuthApply implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long authApplyId;

    /**
     * 申请用户id
     */
	private Long userId;

    /**
     * 
     */
	private Integer authType;

    /**
     * 申请状态:0:未处理 1:通过 2:驳回
     */
	private Integer applyStatus;

    /**
     * 申请时间
     */
	private Date applyTime;

    /**
     * 修改时间
     */
	private Date modifyTime;

    /**
     * 操作日志
     */
	private String modifyLog;

	public void setAuthApplyId(Long authApplyId) {
		this.authApplyId = authApplyId;
	}

	public Long getAuthApplyId() {
		return this.authApplyId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setAuthType(Integer authType) {
		this.authType = authType;
	}

	public Integer getAuthType() {
		return this.authType;
	}

	public void setApplyStatus(Integer applyStatus) {
		this.applyStatus = applyStatus;
	}

	public Integer getApplyStatus() {
		return this.applyStatus;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public Date getApplyTime() {
		return this.applyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Date getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyLog(String modifyLog) {
		this.modifyLog = modifyLog;
	}

	public String getModifyLog() {
		return this.modifyLog;
	}

}