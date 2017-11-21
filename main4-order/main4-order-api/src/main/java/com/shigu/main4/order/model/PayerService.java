package com.shigu.main4.order.model;

import com.shigu.main4.order.exceptions.PayApplyException;
import com.shigu.main4.order.exceptions.PayerException;
import com.shigu.main4.order.vo.PayApplyVO;

import java.util.List;

/**
 * 支付功能
 * Created by zhaohongbo on 17/6/9.
 */
public interface PayerService {
    String OUTER_ID_PRE="payorder_";
    PayApplyVO payApply(Long userId, Long money, String title,Long... oids) throws PayApplyException;

    /**
     * 属于危险的方法，不建议使用
     * @param payId
     * @param money
     * @throws PayerException
     */
    @Deprecated
    void refund(Long payId,Long money) throws PayerException;
    void refund(Long payId,String refundNo,Long money) throws PayerException;
    void payRollback(Long applyId,String outerPid,String outerPuser,Long payMoney,Long money) throws PayerException;
    void paySure(Long applyId,String outerPid,String outerPuser,Long payMoney) throws PayerException;
    Long payedLeft(Long payId);
    PayApplyVO selApply(Long applyId);
}
