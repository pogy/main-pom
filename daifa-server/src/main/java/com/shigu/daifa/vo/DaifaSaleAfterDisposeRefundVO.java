package com.shigu.daifa.vo;

import java.util.List;

public class DaifaSaleAfterDisposeRefundVO {
    private Long refundId;
    private List<DaifaSaleAfterDisposeSubVO> childOrders;

    public Long getRefundId() {
        return this.refundId;
    }

    public void setRefundId(Long refundId) {
        this.refundId = refundId;
    }

    public List<DaifaSaleAfterDisposeSubVO> getChildOrders() {
        return this.childOrders;
    }

    public void setChildOrders(List<DaifaSaleAfterDisposeSubVO> childOrders) {
        this.childOrders = childOrders;
    }
}
