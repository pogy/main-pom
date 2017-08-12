package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class LogisticsTemplateProv implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long tpId;

    /**
     * 规则ID
     */
	private Long ruleId;

    /**
     * 省份ID
     */
	private Long provId;

    /**
     * 模板ID
     */
	private Long templateId;

	public void setTpId(Long tpId) {
		this.tpId = tpId;
	}

	public Long getTpId() {
		return this.tpId;
	}

	public void setRuleId(Long ruleId) {
		this.ruleId = ruleId;
	}

	public Long getRuleId() {
		return this.ruleId;
	}

	public void setProvId(Long provId) {
		this.provId = provId;
	}

	public Long getProvId() {
		return this.provId;
	}

	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}

	public Long getTemplateId() {
		return this.templateId;
	}

}