package com.shigu.main4.order.enums;

/**
 * 1、等待买家付款，2、卖家部分发货，3、等待卖家发货，4、交易完成，5、交易关闭
 * Created by zhaohongbo on 17/5/31.
 */
public enum OrderStatus {
    WAIT_BUYER_PAY(1), //等待买家付款
    BUYER_PAYED(2),//订单已支付
    SELLER_SENDED_GOODS(3), //卖家已发货
    TRADE_FINISHED(4),  //交易完成
    TRADE_CLOSED(5); //付款以后用户退款成功，交易自动关闭

    public final int status;

    OrderStatus(int status) {
        this.status = status;
    }

    public static OrderStatus statusOf(int status) {
        for (OrderStatus orderStatus : values()) {
            if (orderStatus.status == status) {
                return orderStatus;
            }
        }
        throw new IllegalArgumentException(String.format("status %d 不合法", status));
    }
}
