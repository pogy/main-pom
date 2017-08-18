package com.shigu.main4.order.mq.msg;

import java.io.Serializable;

/**
 * Created by bugzy on 2017/8/18 0018.
 */
public class SendAllMessage implements Serializable {

    private Long orderId;
    private String expressCode;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getExpressCode() {
        return expressCode;
    }

    public void setExpressCode(String expressCode) {
        this.expressCode = expressCode;
    }
}
