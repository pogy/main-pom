package com.shigu.main4.order.mq.msg;

import java.io.Serializable;

/**
 * 类名：RefundApplyMessage
 * 类路径：com.shigu.main4.order.mq.msg.RefundApplyMessage
 * 创建者：王浩翔
 * 创建时间：2017-09-21 13:45
 * 项目：main-pom
 * 描述：退货/换货申请消息
 */
public class RefundApplyMessage implements Serializable {
    //退货编号
    private Long refundId;
    //订单号
    private Long oid;
    //1退货退款，2换货
    private Integer type;
    //期望金额（元为单位），如果是换货，此值传0
    private Long hopeMoney;
    //子订单号
    private Long soid;
    //退的件数
    private Integer num;
    //退/换原因
    private String reason;

    public Long getRefundId() {
        return refundId;
    }

    public void setRefundId(Long refundId) {
        this.refundId = refundId;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
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

    public Long getSoid() {
        return soid;
    }

    public void setSoid(Long soid) {
        this.soid = soid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
