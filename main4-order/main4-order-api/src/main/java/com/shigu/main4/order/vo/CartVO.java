package com.shigu.main4.order.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 购物车
 * Created by zhaohongbo on 17/6/1.
 */
public class CartVO extends ItemProductVO implements Serializable, Comparable<CartVO>{
    private Long cartId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 产品skuID
     */
    private Long skuId;

//    /**
//     * 店铺ID
//     */
//    private Long shopId;

    /**
     * 数量
     */
    private Integer num;

    private Date lastModify;

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

//    public Long getShopId() {
//        return shopId;
//    }
//
//    public void setShopId(Long shopId) {
//        this.shopId = shopId;
//    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Date getLastModify() {
        return lastModify;
    }

    public void setLastModify(Date lastModify) {
        this.lastModify = lastModify;
    }

    @Override
    public int compareTo(CartVO o) {
        return o == null ? 1 : lastModify.compareTo(o.getLastModify());
    }
}
