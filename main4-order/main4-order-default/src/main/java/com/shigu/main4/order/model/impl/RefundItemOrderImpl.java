package com.shigu.main4.order.model.impl;

import com.shigu.main4.order.bo.RefundApplyBO;
import com.shigu.main4.order.model.RefundItemOrder;
import com.shigu.main4.order.vo.RefundVO;


/**
 * 退单
 * Created by zhaohongbo on 17/7/20.
 */
public class RefundItemOrderImpl implements RefundItemOrder {

    private Long refundId;

    public RefundItemOrderImpl(Long refundId) {
        this.refundId = refundId;
    }

    /**
     * 退单
     * @param apply
     */
    public RefundItemOrderImpl(RefundApplyBO apply, Boolean fromUser) {
        apply(apply,fromUser);
    }

    @Override
    public RefundVO refundinfo() {
        return null;
    }

    @Override
    public Long apply(RefundApplyBO applyBO, Boolean fromUser) {
        return null;
    }

    @Override
    public void sellerAgree() {

    }

    @Override
    public void sellerRefuse(String reason) {

    }

    @Override
    public void userSended(String buyerCourier) {

    }

    @Override
    public void sellerCached() {

    }

    @Override
    public void success() {

    }

    @Override
    public void error(String reason) {

    }

    public Long getRefundId() {
        return refundId;
    }
}
