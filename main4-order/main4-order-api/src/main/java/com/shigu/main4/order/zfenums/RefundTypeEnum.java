package com.shigu.main4.order.zfenums;

/**
 * Created by zf on 2017/7/17.
 */
public enum RefundTypeEnum {
    NOT_REFUND(0),//无退款
    DISPOSE_REFUND(1),//手动申请退款产生的退款
    ENT_REFUND(2),//自动退款产生的数据
    ;
    public final int refundType;
    RefundTypeEnum(int refundType){
        this.refundType=refundType;
    }
    public static RefundTypeEnum statusOf(int refundType) {
        for (RefundTypeEnum refundTypeEnum : values()) {
            if (refundTypeEnum.refundType == refundType) {
                return refundTypeEnum;
            }
        }
        throw new IllegalArgumentException(String.format("refundType %d 不合法", refundType));
    }
}
