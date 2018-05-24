package com.opentae.data.daifa.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ExpressTemplate implements Serializable {
    /**
     * 模版id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long tId;

    /**
     * 模版名称
     */
	private String templateTitle;

    /**
     * 发货省份
     */
	private Long fromProvId;

    /**
     * 发货城市
     */
	private Long fromCityId;

    /**
     * 发货区域
     */
	private Long fromTownId;

    /**
     * 是否包邮 0：不包，1：包邮
     */
	private Integer free;

    /**
     * 快递公司id
     */
	private Long expressCompanyId;

    /**
     * 是否启用 0：不启用 1：启用
     */
	private Integer enabled;

    /**
     * 是否删除 -1：删除，1：正常
     */
	private Integer templateStatus;

    /**
     * 扩展字段
     */
	private String attribute;

	public void setTId(Long tId) {
		this.tId = tId;
	}

	public Long getTId() {
		return this.tId;
	}

	public void setTemplateTitle(String templateTitle) {
		this.templateTitle = templateTitle;
	}

	public String getTemplateTitle() {
		return this.templateTitle;
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

	public void setFree(Integer free) {
		this.free = free;
	}

	public Integer getFree() {
		return this.free;
	}

	public void setExpressCompanyId(Long expressCompanyId) {
		this.expressCompanyId = expressCompanyId;
	}

	public Long getExpressCompanyId() {
		return this.expressCompanyId;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public Integer getEnabled() {
		return this.enabled;
	}

	public void setTemplateStatus(Integer templateStatus) {
		this.templateStatus = templateStatus;
	}

	public Integer getTemplateStatus() {
		return this.templateStatus;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getAttribute() {
		return this.attribute;
	}

}