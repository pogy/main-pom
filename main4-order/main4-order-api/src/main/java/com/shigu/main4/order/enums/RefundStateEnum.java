package com.shigu.main4.order.enums;

/**
 * Created by zf on 2017/7/17.
 */
public enum RefundStateEnum {
    APPLY_REFUND(0),//申请退款
    DISPOSE_REFUND(1),//商家受理退请求
    ENT_REFUND(2),//退款完成
    SELLER_REFUND(3),//商家拒绝受理
    NOT_REFUND(4),//退款失败
    BUYER_SEND(5),//买家已发件
    SELLER_CACHED(6),//卖家已收件
    SELLER_REPRICE(7),//卖家议价
    BUYER_REPRICE(8),//买家附议
    BUYER_NOREPRICE(9),//买家拒绝附议
    ;
    public final int refundStatus;
    RefundStateEnum(int refundStatus){
        this.refundStatus=refundStatus;
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
