package com.shigu.main4.order.process;

import com.shigu.main4.order.enums.PayType;
import com.shigu.main4.order.exceptions.PayApplyException;
import com.shigu.main4.order.vo.PayApplyVO;

import java.util.List;

/**
 * 支付方式的接口
 */
public interface PayProcess {

    PayApplyVO payApply(Long orderId, PayType payType) throws PayApplyException;

    PayApplyVO payApplySome(List<Long> orderIds,PayType payType) throws PayApplyException;

    PayApplyVO rechargeApply(Long userId,PayType payType,Long money) throws PayApplyException;
}
