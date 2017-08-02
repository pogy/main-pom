package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class LogisticsTemplate implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long templateId;

    /**
     * 
     */
	private Long senderId;

    /**
     * 标题
     */
	private String title;

    /**
     * 1有用，0无用
     */
	private Boolean enabled;

    /**
     * 发货省份ID
     */
	private Long fromProvId;

    /**
     * 发货城市 ID
     */
	private Long fromCityId;

    /**
     * 发货地区ID
     */
	private Long fromTownId;

    /**
     * 1包邮，0不包
     */
	private Boolean free;

	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}

	public Long getTemplateId() {
		return this.templateId;
	}

	public void setSenderId(Long senderId) {
		this.senderId = senderId;
	}

	public Long getSenderId() {
		return this.senderId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Boolean getEnabled() {
		return this.enabled;
	}

	public void setFromProvId(Long fromProvId) {
		this.fromProvId = fromProvId;
	}

	public Long getFromProvId() {
		return this.fromProvId;
	}

	public void setFromCityId(Long fromCityId) {
		this.fromCityId = fromCityId;
	}

	public Long getFromCityId() {
		return this.fromCityId;
	}

	public void setFromTownId(Long fromTownId) {
		this.fromTownId = fromTownId;
	}

	public Long getFromTownId() {
		return this.fromTownId;
	}

	public void setFree(Boolean free) {
		this.free = free;
	}

	public Boolean getFree() {
		return this.free;
	}

}