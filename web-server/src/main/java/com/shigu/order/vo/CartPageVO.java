package com.shigu.order.vo;

import java.util.List;

/**
 * 进货车页面数据
 * Created by bugzy on 2017/6/20 0020.
 */
public class CartPageVO {

    /**
     * 进货车商品总数
     */
    private int goodsCount;

    private List<CartOrderVO> orders;

    public int getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }

    public List<CartOrderVO> getOrders() {
        return orders;
    }

    public void setOrders(List<CartOrderVO> orders) {
        this.orders = orders;
    }
}
