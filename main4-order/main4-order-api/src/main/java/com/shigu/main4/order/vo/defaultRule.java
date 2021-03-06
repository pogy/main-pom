package com.shigu.main4.order.vo;

import java.io.Serializable;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.main4.daifa.vo
 * @ClassName: defaultRule
 * @Author: sy
 * @CreateDate: 2018/4/4 0004 9:35
 */
public class defaultRule implements Serializable{

    private Long freightId;
    private Double costFee;

    public Long getFreightId() {
        return freightId;
    }

    public void setFreightId(Long freightId) {
        this.freightId = freightId;
    }

    public Double getCostFee() {
        return costFee;
    }

    public void setCostFee(Double costFee) {
        this.costFee = costFee;
    }
}
