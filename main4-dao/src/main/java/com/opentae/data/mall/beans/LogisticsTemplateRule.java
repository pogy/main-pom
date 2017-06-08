package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class LogisticsTemplateRule implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long ruleId;

    /**
     * 首重/首件，费用
     */
	private Long firstFee;

    /**
     * 首重/首件起步单位
     */
	private Integer firstUnit;

    /**
     * 每增加单位费用变化
     */
	private Long perFee;

    /**
     * 每增加的单位值
     */
	private Integer perUnit;

    /**
     * 1按件，2按重量
     */
	private Integer type;

    /**
     * 运费模板ID
     */
	private Long templateId;

    /**
     * 1表示默认模板
     */
	private Boolean imDefault;

	public void setRuleId(Long ruleId) {
		this.ruleId = ruleId;
	}

	public Long getRuleId() {
		return this.ruleId;
	}

	public void setFirstFee(Long firstFee) {
		this.firstFee = firstFee;
	}

	public Long getFirstFee() {
		return this.firstFee;
	}

	public void setFirstUnit(Integer firstUnit) {
		this.firstUnit = firstUnit;
	}

	public Integer getFirstUnit() {
		return this.firstUnit;
	}

	public void setPerFee(Long perFee) {
		this.perFee = perFee;
	}

	public Long getPerFee() {
		return this.perFee;
	}

	public void setPerUnit(Integer perUnit) {
		this.perUnit = perUnit;
	}

	public Integer getPerUnit() {
		return this.perUnit;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getType() {
		return this.type;
	}

	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}

	public Long getTemplateId() {
		return this.templateId;
	}

	public void setImDefault(Boolean imDefault) {
		this.imDefault = imDefault;
	}

	public Boolean getImDefault() {
		return this.imDefault;
	}

}