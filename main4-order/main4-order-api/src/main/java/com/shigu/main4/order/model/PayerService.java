package com.shigu.main4.order.model;

import com.shigu.main4.order.vo.PayApplyVO;

/**
 * 支付功能
 * Created by zhaohongbo on 17/6/9.
 */
public interface PayerService {
    PayApplyVO payApply(Long oid, Long money, String title);
    void refund(Long payId,Long money);
    void paySure(Long applyId,String outerPid,String outerPuser,Long payMoney);
    Long payedLeft(Long payId);
}
