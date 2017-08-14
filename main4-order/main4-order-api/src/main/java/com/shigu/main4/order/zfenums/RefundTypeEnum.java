package com.shigu.main4.order.zfenums;

/**
 * Created by wanghaoxiang on 2017/8/3 0003.
 */
public enum  RefundTypeEnum {
    ONLY_REFUND(1),//退款
    GOODS_REFUND(2),//退货
    GOODS_CHANGE(3),//换货
    ;
    public final int type;
    RefundTypeEnum(int type){
        this.type = type;
    }
    public static RefundTypeEnum statusOf(int status) {
        for (RefundTypeEnum refundTypeEnum : values()) {
            if (refundTypeEnum.type == status) {
                return refundTypeEnum;
            }
        }
        throw new IllegalArgumentException(String.format("refundType %d 不合法", status));
    }
}
