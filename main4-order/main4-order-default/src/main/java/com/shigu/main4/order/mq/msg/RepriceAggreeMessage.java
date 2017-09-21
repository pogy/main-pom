package com.shigu.main4.order.mq.msg;

/**
 * Created by cdh on 2017/9/21.
 * Path com.shigu.main4.order.mq.msg.RepriceAggreeMessage
 */
public class RepriceAggreeMessage {

    private Long refundId;
    private boolean agree ;

    public Long getRefundId() {
        return refundId;
    }

    public void setRefundId(Long refundId) {
        this.refundId = refundId;
    }

    public boolean isAgree() {
        return agree;
    }

    public void setAgree(boolean agree) {
        this.agree = agree;
    }
}
