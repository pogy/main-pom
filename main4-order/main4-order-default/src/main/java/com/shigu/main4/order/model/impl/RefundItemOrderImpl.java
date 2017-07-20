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

    /**
     * 退货申请
     * @param applyBO
     * @param fromUser
     * @return
     */
    @Override
    public Long apply(RefundApplyBO applyBO, Boolean fromUser) {
        return null;
    }

    /**
     * 卖家受理
     */
    @Override
    public void sellerAgree() {

    }

    /**
     * 卖家拒绝受理
     * @param reason
     */
    @Override
    public void sellerRefuse(String reason) {

    }

    /**
     * 用户已发件
     * @param buyerCourier
     */
    @Override
    public void userSended(String buyerCourier) {

    }

    /**
     * 卖家收到货
     */
    @Override
    public void sellerCached() {

    }

    /**
     * 退成功
     */
    @Override
    public void success() {

    }

    /**
     * 退失败
     * @param reason
     */
    @Override
    public void error(String reason) {

    }

    public Long getRefundId() {
        return refundId;
    }
}
