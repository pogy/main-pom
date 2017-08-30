package com.shigu.main4.order.enums;

/**
 * Created by whx on 2017/7/21 0021.
 */
public enum  RefundMsgEnum {
    SELLER_AGREE("卖家受理"),
    SELLER_REFUSE("卖家拒绝受理"),
    SELLER_CACHED("卖家已收货"),
    USER_SENDED("买家已发件"),
    SELLER_PROPOSAL("卖家议价"),
    BUYER_NO_REPRICE("买家拒绝附议"),
    ERROR("退件失败"),
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
