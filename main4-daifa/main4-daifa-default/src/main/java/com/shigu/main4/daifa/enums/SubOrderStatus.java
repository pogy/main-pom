package com.shigu.main4.daifa.enums;

/**
 * 代发子订单状态
 */
public enum SubOrderStatus {
    NO_PAY(0),//未付款
    PAYED(1),//已付款
    PACKING(2),//配货中
    SENDED(3)//已发货
    ;

    SubOrderStatus(int value) {
        this.value = value;
    }

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
