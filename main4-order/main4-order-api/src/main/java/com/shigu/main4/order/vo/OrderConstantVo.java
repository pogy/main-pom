package com.shigu.main4.order.vo;

import java.io.Serializable;

/**
 * 订单常量VO，提供ID
 * Created by bugzy on 2017/6/9 0009.
 */
public class OrderConstantVo implements Serializable{
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
