package com.shigu.main4.order.enums;

/**
 * 退货部分子状态
 */
public enum RefundSubInfo {

    SELLERACCPET("售后同意",1),
    BUYERSENDED("售后已发货",2),
    WORKING("档口退货中",3),
    PRICECHANGE("金额改变",4);
    public final String title;

    public final int value;

    RefundSubInfo(String title, int value) {
        this.title = title;
        this.value = value;
    }
}
