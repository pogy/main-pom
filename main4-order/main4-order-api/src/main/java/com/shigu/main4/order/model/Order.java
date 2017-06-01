package com.shigu.main4.order.model;

import com.shigu.main4.order.enums.PayType;
import com.shigu.main4.order.vo.PayApplyVO;

/**
 * 订单
 * Created by zhaohongbo on 17/6/1.
 */
public interface Order {
    /**
     *
     * @param payType
     * @return
     */
    PayApplyVO payApply(PayType payType);
}
