package com.shigu.main4.daifa.vo;

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
    private Integer costFee;

    public Long getFreightId() {
        return freightId;
    }

    public void setFreightId(Long freightId) {
        this.freightId = freightId;
    }

    public Integer getCostFee() {
        return costFee;
    }

    public void setCostFee(Integer costFee) {
        this.costFee = costFee;
    }
}
