package com.shigu.main4.order.bo;

import java.io.Serializable;

/**
 * 退货申请
 * Created by zhaohongbo on 17/7/20.
 */
public class RefundApplyBO implements Serializable{
    /**
     * 主订单号
     */
    private Long oid;
    /**
     * 子订单号
     */
    private Long soid;
    /**
     * 1退款，2A类退货，3B类退货
     */
    private Integer type;
    /**
     * 期望得到金额
     */
    private Long hopeMoney;

    /**
     * 件数
     */
    private Integer number;
    /**
     * 原因
     */
    private String reason;

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Long getSoid() {
        return soid;
    }

    public void setSoid(Long soid) {
        this.soid = soid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getHopeMoney() {
        return hopeMoney;
    }

    public void setHopeMoney(Long hopeMoney) {
        this.hopeMoney = hopeMoney;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber( Integer number ) {
        this.number = number;
    }
}
