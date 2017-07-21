package com.shigu.main4.order.enums;

/**
 * Created by whx on 2017/7/21 0021.
 */
public enum  RefundMsgEnum {
    SELLER_AGREE("卖家受理"),
    SELLER_REFUSE("卖家拒绝受理"),

    USER_SENDED("买家已发件"),
    ;
    public final String refundMsg;
    RefundMsgEnum(String refundMsg) {
        this.refundMsg = refundMsg;
    }

    @Override
    public String toString() {
        return refundMsg;
    }
}
