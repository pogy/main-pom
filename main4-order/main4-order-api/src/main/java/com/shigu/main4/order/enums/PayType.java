package com.shigu.main4.order.enums;

/**
 * 支付方式
 * Created by zhaohongbo on 17/5/31.
 */
public enum PayType {
    XZ(3),  //星座
    ALI(2),  //阿里
    WX(1);  //微信

    PayType(Integer value) {
        this.value = value;
    }

    private Integer value;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
