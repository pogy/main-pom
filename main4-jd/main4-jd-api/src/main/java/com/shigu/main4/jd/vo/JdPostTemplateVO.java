package com.shigu.main4.jd.vo;

import java.io.Serializable;

/**
 * Created By admin on 2017/12/26/15:25
 */
public class JdPostTemplateVO implements Serializable {
    /**
     * 单品模板编号
     */
    private Long id;
    /**
     * 顺序号
     */
    private Integer index;
    /**
     * 模板名称
     */
    private String templateName;
    /**
     * 计费规则
     */
    private Integer ruleType;
    /**
     * 是否卖家包邮
     */
    private Integer isFree;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public Integer getRuleType() {
        return ruleType;
    }

    public void setRuleType(Integer ruleType) {
        this.ruleType = ruleType;
    }

    public Integer getIsFree() {
        return isFree;
    }

    public void setIsFree(Integer isFree) {
        this.isFree = isFree;
    }
}
