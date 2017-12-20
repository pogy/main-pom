package com.shigu.main4.order.vo;

import java.io.Serializable;

/**
 * 产品父类
 * Created by zhaohongbo on 17/6/9.
 */
public class ProductVO implements Serializable{

    private Long price;

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
