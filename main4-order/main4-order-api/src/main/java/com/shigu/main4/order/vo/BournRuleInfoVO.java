package com.shigu.main4.order.vo;

import java.io.Serializable;

/**
 * 目的地价格规则
 * Created by bugzy on 2017/7/18 0018.
 */
public class BournRuleInfoVO implements Serializable{

    private Long ruleId;

    private Integer startWeight;

    private Long startPrice;

    private Long provId;

    private Long companyId;

    private Integer addWeight;

    private Long addPrice;

    /**
     * 1按件，2按重量
     */
    private Integer type;

    private Boolean imDefault;

    public Long getRuleId() {
        return ruleId;
    }

    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }

    public Integer getStartWeight() {
        return startWeight;
    }

    public void setStartWeight(Integer startWeight) {
        this.startWeight = startWeight;
    }

    public Long getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Long startPrice) {
        this.startPrice = startPrice;
    }

    public Long getProvId() {
        return provId;
    }

    public void setProvId(Long provId) {
        this.provId = provId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Integer getAddWeight() {
        return addWeight;
    }

    public void setAddWeight(Integer addWeight) {
        this.addWeight = addWeight;
    }

    public Long getAddPrice() {
        return addPrice;
    }

    public void setAddPrice(Long addPrice) {
        this.addPrice = addPrice;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Boolean getImDefault() {
        return imDefault;
    }

    public void setImDefault(Boolean imDefault) {
        this.imDefault = imDefault;
    }
}
