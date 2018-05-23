package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ExpressRule implements Serializable {
    /**
     * 快递模版下规则id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long rId;

    /**
     * 父规则id
     */
	private Long parentRuleId;

    /**
     * 子规则的标题
     */
	private String ruleTile;

    /**
     * 阈值
     */
	private Integer threshold;

    /**
     * 阈中的单件或每斤的价格
     */
	private Integer thresholdFree;

    /**
     * 规则所属模版id
     */
	private Long etId;

    /**
     * 是否为默认规则 1：默认，2：非默认
     */
	private Integer isDefault;

    /**
     * 是否为父规则 1：夫规则，2：子规则
     */
	private Integer isParentRule;

    /**
     * 按重量或件数 0：件数，1：数量
     */
	private Integer ruleType;

    /**
     * -1：删除，1：正常
     */
	private Integer ruleStatus;

    /**
     * 扩展字段
     */
	private String attribute;

	public void setRId(Long rId) {
		this.rId = rId;
	}

	public Long getRId() {
		return this.rId;
	}

	public void setParentRuleId(Long parentRuleId) {
		this.parentRuleId = parentRuleId;
	}

	public Long getParentRuleId() {
		return this.parentRuleId;
	}

	public void setRuleTile(String ruleTile) {
		this.ruleTile = ruleTile;
	}

	public String getRuleTile() {
		return this.ruleTile;
	}

	public void setThreshold(Integer threshold) {
		this.threshold = threshold;
	}

	public Integer getThreshold() {
		return this.threshold;
	}

	public void setThresholdFree(Integer thresholdFree) {
		this.thresholdFree = thresholdFree;
	}

	public Integer getThresholdFree() {
		return this.thresholdFree;
	}

	public void setEtId(Long etId) {
		this.etId = etId;
	}

	public Long getEtId() {
		return this.etId;
	}

	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}

	public Integer getIsDefault() {
		return this.isDefault;
	}

	public void setIsParentRule(Integer isParentRule) {
		this.isParentRule = isParentRule;
	}

	public Integer getIsParentRule() {
		return this.isParentRule;
	}

	public void setRuleType(Integer ruleType) {
		this.ruleType = ruleType;
	}

	public Integer getRuleType() {
		return this.ruleType;
	}

	public void setRuleStatus(Integer ruleStatus) {
		this.ruleStatus = ruleStatus;
	}

	public Integer getRuleStatus() {
		return this.ruleStatus;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getAttribute() {
		return this.attribute;
	}

}