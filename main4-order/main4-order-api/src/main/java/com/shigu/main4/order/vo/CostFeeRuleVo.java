package com.shigu.main4.order.vo;

import java.io.Serializable;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.main4.daifa.vo
 * @ClassName: CostFeeRuleVo
 * @Author: sy
 * @CreateDate: 2018/4/4 0004 9:13
 */
public class CostFeeRuleVo implements Serializable{

    private Long freightChildId;
    private Double costFee;
    private Integer threshold;

    public Long getFreightChildId() {
        return freightChildId;
    }

    public void setFreightChildId(Long freightChildId) {
        this.freightChildId = freightChildId;
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
