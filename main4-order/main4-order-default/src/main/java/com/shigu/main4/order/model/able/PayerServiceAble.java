package com.shigu.main4.order.model.able;

import com.shigu.main4.order.model.PayerService;
import com.shigu.main4.order.vo.PayApplyVO;

/**
 * 支付部分实现
 * Created by zhaohongbo on 17/6/9.
 */
public abstract class PayerServiceAble implements PayerService{

    @Override
    public Long payedLeft(Long payId) {
        return null;
    }

    @Override
    public void paySure(Long applyId, String outerPid, String outerPuser, Long payMoney) {

    }

    @Override
    public PayApplyVO selApply(Long applyId) {
        return null;
    }
}
