package com.shigu.main4.order.model;

import com.shigu.main4.order.bo.RefundApplyBO;

/**
 * 商品退单
 * Created by zhaohongbo on 17/7/20.
 */
public interface RefundItemOrder {
    /**
     * 退货申请
     * @param applyBO
     * @param fromUser
     * @return
     */
    Long apply(RefundApplyBO applyBO,Boolean fromUser);

    /**
     * 卖家受理
     */
    void sellerAgree();

    /**
     * 卖家拒绝受理
     * @param reason
     */
    void sellerRefuse(String reason);

    /**
     * 用户已发件
     * @param buyerCourier
     */
    void userSended(String buyerCourier);

    /**
     * 卖家收到货
     */
    void sellerCached();

    /**
     * 退成功
     */
    void success();

    /**
     * 退失败
     * @param reason
     */
    void error(String reason);
}
