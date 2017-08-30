package com.shigu.main4.order.model;

import com.shigu.main4.order.exceptions.PayApplyException;

/**
 * 充值订单
 * Created by zhaohongbo on 17/6/1.
 */
public interface RechargeOrder extends Order{

    /**
     * 支付完成
     */
    void payed(String alipayNo) throws PayApplyException;//支付完成
}
