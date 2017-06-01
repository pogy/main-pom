package com.shigu.main4.order.services;

import com.shigu.main4.order.bo.ItemOrderBO;

/**
 * 商品交易订单服务
 * Created by zhaohongbo on 17/6/1.
 */
public interface ItemOrderService {
    /**
     * 创建一个订单
     * @param orderBO 订单数据
     * @return
     */
    Long createOrder(ItemOrderBO orderBO);
}
