package com.shigu.main4.order.mq.msg;

import java.io.Serializable;

/**
 * Created by cdh on 2017/9/21.
 * Path com.shigu.main4.order.mq.msg.RepriceApplyMessage
 */
public class RepriceApplyMessage implements Serializable {

    //退货ID
    private Long refundId;
    //店家能给的退货款
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
