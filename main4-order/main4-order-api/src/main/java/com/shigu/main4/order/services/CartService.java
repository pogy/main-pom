package com.shigu.main4.order.services;

/**
 * Created by zf on 2017/7/25.
 * 进货车
 */
public interface CartService {
    /**
     * 查询进货车数量
     * @param userId
     * @return
     */
    int userCartNum(Long userId);
}
