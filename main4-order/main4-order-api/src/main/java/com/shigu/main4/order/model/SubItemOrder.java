package com.shigu.main4.order.model;

import com.shigu.main4.order.vo.RefundVO;
import com.shigu.main4.order.vo.SubItemOrderVO;

/**
 * 商品子订单
 * Created by zhaohongbo on 17/6/1.
 */
public interface SubItemOrder extends SubOrder{

    /**
     * 获取子单信息
     * @return
     */
    SubItemOrderVO subOrderInfo();

    /**
     * 退款申请
     * @param type 0未确定,1退款，2A类退货，3B类退货,4换货
     * @param number 退件数
     * @param money 退钱数
     */
    Long refundApply(Integer type,Integer number,Long money,String reason);

    /**
     * 退单信息
     * @return
     */
    RefundVO refundInfos();
}
