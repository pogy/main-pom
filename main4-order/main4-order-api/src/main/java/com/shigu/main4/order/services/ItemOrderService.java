package com.shigu.main4.order.services;

import com.shigu.main4.order.bo.ItemOrderBO;

/**
 * 商品交易订单服务
 * Created by zhaohongbo on 17/6/1.
 */
public interface ItemOrderService {

    /**
     * 创建订单
     * @param orderBO
     * @return
     */
    Long createOrder(ItemOrderBO orderBO);
}
