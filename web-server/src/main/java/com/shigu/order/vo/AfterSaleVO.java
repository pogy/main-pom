package com.shigu.order.vo;

import com.opentae.core.mybatis.config.Column;

/**
 * Created by bugzy on 2017/8/23 0023.
 */
public class AfterSaleVO {

    @Column("item_order_refund.refund_id")
    private Long refundId;
    @Column("item_order_refund.number")
    private Integer afterSaleNum;
    @Column("item_order_refund.type")
    private Integer type;
    @Column("IF(ISNULL(item_order_refund.status),NULL,IF(item_order_refund.status=2,2,IF(item_order_refund.status=4,3,1)))")
    private Integer state;

    public Long getRefundId() {
        return refundId;
    }

    public void setRefundId(Long refundId) {
        this.refundId = refundId;
    }

    public Integer getAfterSaleNum() {
        return afterSaleNum;
    }

    public void setAfterSaleNum(Integer afterSaleNum) {
        this.afterSaleNum = afterSaleNum;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}