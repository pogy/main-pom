package com.shigu.main4.order.vo;

import java.io.Serializable;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.main4.daifa.vo
 * @ClassName: editDefaultRuleVo
 * @Author: sy
 * @CreateDate: 2018/4/4 0004 17:19
 */
public class editDefaultRuleVo implements Serializable{
    private Long freightId;
    private String text;
    private Double costFee;
    private Integer threshold;

    public Long getFreightId() {
        return freightId;
    }

    public void setFreightId(Long freightId) {
        this.freightId = freightId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Double getCostFee() {
        return costFee;
    }

    public void setCostFee(Double costFee) {
        this.costFee = costFee;
    }

    public Integer getThreshold() {
        return threshold;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }
}
