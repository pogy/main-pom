package com.shigu.main4.order.zfenums;

/**
 * Created by zf on 2017/7/17.
 */
public enum  MainOrderStatusEnum {
    WAIT_BUYER_PAY(1),//待付款
    WAIT_SELLER_TASKS_GOODS(2),//待分配
    SELLER_SEND_GOODS(3),//已发货
    ORDER_ENT(4),//交易完成
    ORDER_CLOSE(5),//交易取消
    ;

    public final int status;

    MainOrderStatusEnum(int status) {
        this.status = status;
    }

    public static MainOrderStatusEnum statusOf(int status) {
        for (MainOrderStatusEnum orderStatus : values()) {
            if (orderStatus.status == status) {
                return orderStatus;
            }
        }
        throw new IllegalArgumentException(String.format("status %d 不合法", status));
    }
}
