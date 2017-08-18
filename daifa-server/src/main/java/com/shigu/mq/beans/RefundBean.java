package com.shigu.mq.beans;

import java.io.Serializable;
import java.util.List;

public class RefundBean implements Serializable{
    private Long refundId;
    private List<SubRefundBean> suborders;

    public Long getRefundId() {
        return this.refundId;
    }

    public void setRefundId(Long refundId) {
        this.refundId = refundId;
    }

    public List<SubRefundBean> getSuborders () {
        return suborders;
    }

    public void setSuborders (List<SubRefundBean> suborders) {
        this.suborders = suborders;
    }
}
