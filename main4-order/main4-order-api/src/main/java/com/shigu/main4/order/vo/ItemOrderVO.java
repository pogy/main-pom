package com.shigu.main4.order.vo;

/**
 * 商品类别订单
 * Created by zhaohongbo on 17/6/1.
 */
public class ItemOrderVO extends OrderVO{

    private Long senderId;

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }
}
