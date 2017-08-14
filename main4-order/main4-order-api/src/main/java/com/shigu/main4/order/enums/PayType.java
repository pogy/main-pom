package com.shigu.main4.order.enums;

/**
 * 支付方式
 * Created by zhaohongbo on 17/5/31.
 */
public enum PayType {
    XZ(3, "xzPayerService"),  //星座
    ALI(2, "aliPayerService"),  //阿里
    WX(1, "wxPayerService");  //微信

    PayType(Integer value, String service) {
        this.value = value;
        this.service = service;
    }

    private Integer value;

    private String service;

    public Integer getValue() {
        return value;
    }

    public String getService() {
        return service;
    }
    public static PayType valueOf(int value) {
        for (PayType type : values()) {
            if (type.value == value) {
                return type;
            }
        }
        throw new IllegalArgumentException(String.format("status %d 不合法", value));
    }
}
