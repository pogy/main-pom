package com.shigu.main4.order.vo;

import java.io.Serializable;

/**
 * 购物车
 * Created by zhaohongbo on 17/6/1.
 */
public class CartVO extends ItemProductVO implements Serializable{
    private Long cartId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 产品skuID
     */
    private Long skuId;

    /**
     * 数量
     */
    private Integer num;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
