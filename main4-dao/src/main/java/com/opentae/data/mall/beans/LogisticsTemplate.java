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
	private String templateId;

    /**
     * 发送单位属主ID
     */
	private String senderId;

    /**
     * 标题
     */
	private String title;

    /**
     * 1有用，0无用
     */
	private String enabled;

    /**
     * 发货省份ID
     */
	private String fromProvId;

    /**
     * 发货城市 ID
     */
	private String fromCityId;

    /**
     * 发货地区ID
     */
	private String fromTownId;

    /**
     * 1包邮，0不包
     */
	private String free;

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getTemplateId() {
		return this.templateId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public String getSenderId() {
		return this.senderId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getEnabled() {
		return this.enabled;
	}

	public void setFromProvId(String fromProvId) {
		this.fromProvId = fromProvId;
	}

	public String getFromProvId() {
		return this.fromProvId;
	}

	public void setFromCityId(String fromCityId) {
		this.fromCityId = fromCityId;
	}

	public String getFromCityId() {
		return this.fromCityId;
	}

	public void setFromTownId(String fromTownId) {
		this.fromTownId = fromTownId;
	}

	public String getFromTownId() {
		return this.fromTownId;
	}

	public void setFree(String free) {
		this.free = free;
	}

	public String getFree() {
		return this.free;
	}

}