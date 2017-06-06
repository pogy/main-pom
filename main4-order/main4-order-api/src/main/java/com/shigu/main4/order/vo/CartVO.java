package com.shigu.main4.order.vo;

import java.io.Serializable;

/**
 * 购物车
 * Created by zhaohongbo on 17/6/1.
 */
public class CartVO implements Serializable{
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
