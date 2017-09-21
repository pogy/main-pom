package com.shigu.main4.order.mq.msg;

import java.io.Serializable;

/**
 * Created by cdh on 2017/9/21.
 * Path com.shigu.main4.order.mq.msg.RepriceAgreeMessage
 */
public class RepriceAgreeMessage implements Serializable{
    //退货编号
    private Long refundId;
    //true或false，同意或拒绝
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
