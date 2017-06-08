package com.shigu.main4.order.enums;

/**
 * 订单类别
 * Created by zhaohongbo on 17/5/31.
 */
public enum OrderType {
    XZ(1); //星座商品的订单

    public int type;
    OrderType(int type) {
        this.type = type;
    }

    public static OrderType typeOf(int type) {
        for (OrderType orderType : values()) {
            if (type == orderType.type)
                return orderType;
        }
        throw new IllegalArgumentException(String.format("type[%d] 不存在", type));
    }
}
