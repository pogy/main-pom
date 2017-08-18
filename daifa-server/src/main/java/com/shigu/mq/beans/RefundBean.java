package com.shigu.mq.beans;

import java.io.Serializable;
import java.util.List;

public class RefundBean implements Serializable{
    private Long refundId;
    private SubRefundBean suborders;

    public Long getRefundId() {
        return this.refundId;
    }

    public void setRefundId(Long refundId) {
        this.refundId = refundId;
    }

    public SubRefundBean getSuborders() {
        return this.suborders;
    }

    public void setSuborders(SubRefundBean suborders) {
        this.suborders = suborders;
    }
}
