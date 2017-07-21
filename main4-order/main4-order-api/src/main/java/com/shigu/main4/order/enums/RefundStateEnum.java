package com.shigu.main4.order.enums;

/**
 * Created by zf on 2017/7/17.
 */
public enum RefundStateEnum {
    APPLY_REFUND(0, true),//申请退款
    DISPOSE_REFUND(1, false),//商家受理退请求
    ENT_REFUND(2, null),//退款完成
    SELLER_REFUND(3, false),//商家拒绝受理
    NOT_REFUND(4, false),//退款失败
    BUYER_SEND(5, true),//买家已发件
    SELLER_CACHED(6, false),//卖家已收件
    SELLER_REPRICE(7, false),//卖家议价
    BUYER_NOREPRICE(9, true),//买家拒绝附议
    ;
    public final int refundStatus;
    public final Boolean imBuyer;
    RefundStateEnum(int refundStatus, Boolean imBuyer){
        this.refundStatus=refundStatus;
        this.imBuyer = imBuyer;
    }
    public static RefundStateEnum statusOf(int refundStatus) {
        for (RefundStateEnum refundStateEnum : values()) {
            if (refundStateEnum.refundStatus == refundStatus) {
                return refundStateEnum;
            }
        }
        throw new IllegalArgumentException(String.format("refundStatus %d 不合法", refundStatus));
    }
}
