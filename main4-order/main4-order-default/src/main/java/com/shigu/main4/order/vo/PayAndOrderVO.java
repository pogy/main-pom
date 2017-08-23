package com.shigu.main4.order.vo;

import com.opentae.core.mybatis.config.Column;

/**
 * 交易与支付记录关联
 */
public class PayAndOrderVO {
    @Column("order_pay.pay_id")
    private Long payId;
    @Column("order_pay.apply_id")
    private Long applyId;
    @Column("order_pay_relationship.oid")
    private Long oid;

    public Long getPayId() {
        return payId;
    }

    public void setPayId(Long payId) {
        this.payId = payId;
    }

    public Long getApplyId() {
        return applyId;
    }

    public void setApplyId(Long applyId) {
        this.applyId = applyId;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }
}
