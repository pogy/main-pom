package com.shigu.main4.order.vo;

import java.io.Serializable;

/**
 * 商品产品式数据
 * Created by zhaohongbo on 17/6/1.
 */
public class ItemProductVO implements Serializable{

    private Long price;

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
