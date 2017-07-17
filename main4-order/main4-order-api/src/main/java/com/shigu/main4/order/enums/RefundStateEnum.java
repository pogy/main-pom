package com.shigu.main4.order.enums;

/**
 * Created by zf on 2017/7/17.
 */
public enum RefundStateEnum {
    APPLY_REFUND(0),//申请退款
    DISPOSE_REFUND(1),//等待退款处理退款申请
    ENT_REFUND(2),//退款完成
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
