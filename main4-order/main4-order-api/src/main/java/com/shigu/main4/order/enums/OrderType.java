package com.shigu.main4.order.enums;

/**
 * 订单类别
 * Created by zhaohongbo on 17/5/31.
 */
public enum OrderType {
    XZ(1), //星座商品的订单
    TB(2), //淘宝订单转化的订单
    INCHANGE(-1),//充值//不会写入itemOrder
    ;

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
