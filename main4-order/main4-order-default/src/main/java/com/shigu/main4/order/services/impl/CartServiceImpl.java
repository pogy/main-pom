package com.shigu.main4.order.services.impl;

import com.shigu.main4.order.services.CartService;

/**
 * Created by zf on 2017/7/25.
 * 进货车服务实现
 */
public class CartServiceImpl implements CartService{
    @Override
    public int userCartNum(Long userId) {
        return 1;
    }
}
