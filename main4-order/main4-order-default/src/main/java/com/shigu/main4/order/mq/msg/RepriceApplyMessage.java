package com.shigu.main4.order.mq.msg;

/**
 * Created by cdh on 2017/9/21.
 * Path com.shigu.main4.order.mq.msg.RepriceApplyMessage
 */
public class RepriceApplyMessage {
    private Long refundId;
    private Long storeMoney;

    public Long getRefundId() {
        return refundId;
    }

    public void setRefundId(Long refundId) {
        this.refundId = refundId;
    }

    public Long getStoreMoney() {
        return storeMoney;
    }

    public void setStoreMoney(Long storeMoney) {
        this.storeMoney = storeMoney;
    }
}
