package com.shigu.main4.order.model.impl;

import com.shigu.main4.order.model.PayerService;
import com.shigu.main4.order.vo.PayApplyVO;

/**
 * 微信支付
 * Created by zhaohongbo on 17/6/9.
 */
public class WxPayerServiceImpl implements PayerService{
    @Override
    public PayApplyVO payApply(Long oid, Long money, String title) {
        return null;
    }

    @Override
    public void refund(Long payId, Long money) {

    }

    @Override
    public void paySure(Long appayId) {

    }
}
