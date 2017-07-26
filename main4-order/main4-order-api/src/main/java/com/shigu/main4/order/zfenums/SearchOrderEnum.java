package com.shigu.main4.order.zfenums;

/**
 * Created by zf on 2017/7/17.
 */
public enum SearchOrderEnum {
    ALL_ORDER(1),
    WAIT_BUYER_PAY(2),
    WAIT_SELLER_TASKS_GOODS(3),
    SEND_GOODS(4),
    ORDER_ENT(5),
    ORDER_CLOSE(6),
    ;

    public final int status;

    SearchOrderEnum(int status) {
        this.status = status;
    }

    public static SearchOrderEnum statusOf(int status) {
        for (SearchOrderEnum orderStatus : values()) {
            if (orderStatus.status == status) {
                return orderStatus;
            }
        }
        throw new IllegalArgumentException(String.format("status %d 不合法", status));
    }
}
