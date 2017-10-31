package com.shigu.daifa.vo;

import java.util.List;

public class DaifaSaleAfterDisposeRefundVO {
    private Long refundId;
    private Boolean allNotPutInIs;
    private Boolean refundIs;
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

    public Boolean getAllNotPutInIs() {
        return this.allNotPutInIs;
    }

    public void setAllNotPutInIs(Boolean allNotPutInIs) {
        this.allNotPutInIs = allNotPutInIs;
    }

    public Boolean getRefundIs() {
        return this.refundIs;
    }

    public void setRefundIs(Boolean refundIs) {
        this.refundIs = refundIs;
    }
}
