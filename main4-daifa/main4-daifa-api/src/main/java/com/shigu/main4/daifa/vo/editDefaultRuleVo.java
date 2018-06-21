package com.shigu.main4.daifa.vo;

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
    private Integer costFee;

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

    public Integer getCostFee() {
        return costFee;
    }

    public void setCostFee(Integer costFee) {
        this.costFee = costFee;
    }
}
