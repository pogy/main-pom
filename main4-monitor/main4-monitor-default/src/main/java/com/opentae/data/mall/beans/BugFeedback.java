package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class BugFeedback implements Serializable {
    /**
     * 问题反馈表ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long feedbackId;

    /**
     * 用户ID
     */
	private Long userId;

    /**
     * 手机品牌
     */
	private String brand;

    /**
     * 手机型号
     */
	private String mobileModel;

    /**
     * 操作系统版本号
     */
	private String osVersion;

    /**
     * 请求版本号
     */
	private String openVersion;

    /**
     * 具体反馈内容
     */
	private String bugs;

    /**
     *
     */
	private Date createTime;

	public void setFeedbackId(Long feedbackId) {
		this.feedbackId = feedbackId;
	}

	public Long getFeedbackId() {
		return this.feedbackId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setMobileModel(String mobileModel) {
		this.mobileModel = mobileModel;
	}

	public String getMobileModel() {
		return this.mobileModel;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public String getOsVersion() {
		return this.osVersion;
	}

	public void setOpenVersion(String openVersion) {
		this.openVersion = openVersion;
	}

	public String getOpenVersion() {
		return this.openVersion;
	}

	public void setBugs(String bugs) {
		this.bugs = bugs;
	}

	public String getBugs() {
		return this.bugs;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

}