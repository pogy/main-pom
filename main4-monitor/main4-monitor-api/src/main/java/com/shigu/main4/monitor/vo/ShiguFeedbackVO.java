package com.shigu.main4.monitor.vo;


import java.io.Serializable;
import java.util.Date;

public class ShiguFeedbackVO implements Serializable {
    /**
     * feedback_id
     */
	private Long feedbackId;

    /**
     * 标题
     */
	private String title;

    /**
     * 用户ID
     */
	private Long userId;

    /**
     * 内容
     */
	private String fcontents;

    /**
     * bug处理情况：0 待处理，1已处理
     */
	private Integer status;

    /**
     *
     */
	private Date updateTime;

    /**
     *
     */
	private Date createTime;

	/**
	 * 手机品牌
	 */
	private String phoneBrand;

	/**
	 * 手机型号
	 */
	private String phoneModel;

	/**
	 * 操作系统版本号
	 */
	private String osVersion;

	/**
	 * 请求接口的版本号
	 */
	private String openVersion;

    /**
     * 备用
     */
	private String remark5;

	public void setFeedbackId(Long feedbackId) {
		this.feedbackId = feedbackId;
	}

	public Long getFeedbackId() {
		return this.feedbackId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setFcontents(String fcontents) {
		this.fcontents = fcontents;
	}

	public String getFcontents() {
		return this.fcontents;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public String getPhoneBrand() {
		return phoneBrand;
	}

	public void setPhoneBrand(String phoneBrand) {
		this.phoneBrand = phoneBrand;
	}

	public String getPhoneModel() {
		return phoneModel;
	}

	public void setPhoneModel(String phoneModel) {
		this.phoneModel = phoneModel;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public String getOpenVersion() {
		return openVersion;
	}

	public void setOpenVersion(String openVersion) {
		this.openVersion = openVersion;
	}

	public void setRemark5(String remark5) {
		this.remark5 = remark5;
	}

	public String getRemark5() {
		return this.remark5;
	}

}