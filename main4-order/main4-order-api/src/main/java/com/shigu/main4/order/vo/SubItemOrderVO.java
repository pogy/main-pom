package com.shigu.main4.order.vo;

import com.shigu.main4.order.enums.OrderStatus;

import java.io.Serializable;

/**
 * 商品子订单对象
 * Created by zhaohongbo on 17/6/1.
 */
public class SubItemOrderVO extends SubOrderVO implements Serializable{

    private ItemProductVO product;
    private Integer number;
    private OrderStatus status;

    public ItemProductVO getProduct() {
        return product;
    }

    public void setProduct(ItemProductVO product) {
        this.product = product;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}