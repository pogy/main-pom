package com.shigu.main4.order.mq.msg;

import java.io.Serializable;
import java.util.List;

/**
 * 退款信息
 * Created by bugzy on 2017/8/14 0014.
 */
public class RefundMessage implements Serializable {

    private Long refundId;
    private List<SubOrderMessage> suborders;
    /**
     * 退货使用
     */
    private Long money;
    private String reason;

    public Long getRefundId() {
        return refundId;
    }

    public void setRefundId(Long refundId) {
        this.refundId = refundId;
    }

    public List<SubOrderMessage> getSuborders() {
        return suborders;
    }

    public void setSuborders(List<SubOrderMessage> suborders) {
        this.suborders = suborders;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
