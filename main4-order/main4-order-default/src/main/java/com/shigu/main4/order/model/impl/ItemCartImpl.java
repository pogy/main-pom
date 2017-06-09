package com.shigu.main4.order.model.impl;

import com.shigu.main4.order.model.Cart;
import com.shigu.main4.order.vo.ProductVO;

/**
 * 商品购物车实现
 * Created by zhaohongbo on 17/6/9.
 */
public class ItemCartImpl implements Cart{

    @Override
    public <T extends ProductVO> void addProduct(T pro) {
    }

    @Override
    public void rmProduct(Long cartId) {

    }

    @Override
    public Long modifyProductNumber(Long cartId, Integer number) {
        return null;
    }

    @Override
    public Long modifyProductSku(Long cartId, Long skuId) {
        return null;
    }
}
