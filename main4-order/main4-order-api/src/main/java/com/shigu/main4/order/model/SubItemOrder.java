package com.shigu.main4.order.model;

import com.shigu.main4.order.vo.SubItemOrderVO;

/**
 * 商品子订单
 * Created by zhaohongbo on 17/6/1.
 */
public interface SubItemOrder extends SubOrder{

    SubItemOrderVO subOrderInfo();

    /**
     * 退款申请
     * @param number 退件数
     * @param money
     */
    Long refundApply(Integer number,Long money);
}
