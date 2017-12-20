package com.shigu.main4.order.mq.msg;

import java.io.Serializable;
import java.util.List;

/**
 * Created by bugzy on 2017/8/18 0018.
 */
public class StopTradeMessage implements Serializable {

    private Long orderId;
    private List<Long> refundSubOrderIds;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public List<Long> getRefundSubOrderIds() {
        return refundSubOrderIds;
    }

    public void setRefundSubOrderIds(List<Long> refundSubOrderIds) {
        this.refundSubOrderIds = refundSubOrderIds;
    }
}
