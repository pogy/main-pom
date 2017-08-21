package com.shigu.main4.order.vo;

import com.shigu.main4.order.zfenums.SubOrderStatus;

import java.io.Serializable;

/**
 * 商品子订单对象
 * Created by zhaohongbo on 17/6/1.
 */
public class SubItemOrderVO extends SubOrderVO implements Serializable{

    private ItemProductVO product;
    private SubOrderStatus subOrderStatus;

    public ItemProductVO getProduct() {
        return product;
    }

    public void setProduct(ItemProductVO product) {
        this.product = product;
    }

    public SubOrderStatus getSubOrderStatus() {
        return subOrderStatus;
    }

    public void setSubOrderStatus(SubOrderStatus subOrderStatus) {
        this.subOrderStatus = subOrderStatus;
    }
}
