package com.shigu.main4.order.services;

import com.shigu.main4.order.vo.OrderVO;

/**
 * 商品交易订单服务
 * Created by zhaohongbo on 17/6/1.
 */
public interface ItemOrderService {
    /**
     * 创建一个订单
     * @param orderVO
     * @return
     */
    Long createOrder(OrderVO orderVO);
}
