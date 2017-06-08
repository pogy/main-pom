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
	private String ruleId;

    /**
     * 首重/首件，费用
     */
	private String firstFee;

    /**
     * 首重/首件起步单位
     */
	private String firstUnit;

    /**
     * 每增加单位费用变化
     */
	private String perFee;

    /**
     * 每增加的单位值
     */
	private String perUnit;

    /**
     * 1按件，2按重量
     */
	private String type;

    /**
     * 运费模板ID
     */
	private String templateId;

    /**
     * 1表示默认模板
     */
	private String imDefault;

	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}

	public String getRuleId() {
		return this.ruleId;
	}

	public void setFirstFee(String firstFee) {
		this.firstFee = firstFee;
	}

	public String getFirstFee() {
		return this.firstFee;
	}

	public void setFirstUnit(String firstUnit) {
		this.firstUnit = firstUnit;
	}

	public String getFirstUnit() {
		return this.firstUnit;
	}

	public void setPerFee(String perFee) {
		this.perFee = perFee;
	}

	public String getPerFee() {
		return this.perFee;
	}

	public void setPerUnit(String perUnit) {
		this.perUnit = perUnit;
	}

	public String getPerUnit() {
		return this.perUnit;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return this.type;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getTemplateId() {
		return this.templateId;
	}

	public void setImDefault(String imDefault) {
		this.imDefault = imDefault;
	}

	public String getImDefault() {
		return this.imDefault;
	}

}