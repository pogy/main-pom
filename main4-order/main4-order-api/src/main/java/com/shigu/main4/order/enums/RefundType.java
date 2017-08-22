package com.shigu.main4.order.enums;

/**
 * 退类型
 */
public enum RefundType {

    NO_ITEM(1),//退款
    HAS_ITEM(2),//退货
    CHSNGE(3) ;//换货

    RefundType(int value) {
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
