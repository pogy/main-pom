package com.shigu.main4.order.enums;

/**
 * Created by zhaohongbo on 17/5/31.
 */
public enum OrderStatus {
    WAIT_BUYER_PAY, //等待买家付款
    SELLER_CONSIGNED_PART, //卖家部分发货
    WAIT_SELLER_SEND_GOODS, //等待卖家发货
    TRADE_FINISHED,  //交易完成
    TRADE_CLOSED; //付款以后用户退款成功，交易自动关闭
}
