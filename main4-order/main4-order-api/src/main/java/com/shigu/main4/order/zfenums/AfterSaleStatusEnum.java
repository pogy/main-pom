package com.shigu.main4.order.zfenums;

/**
 * Created by zf on 2017/7/17.
 */
public enum AfterSaleStatusEnum {
    NOT_AFTER_SALE(0),//无售后
    HANDLE(1), //处理中
    REFUND_ENT(2),//已退款
    CHANGE_ENT(3),//以换货
    DISPOSE_FERUND(4),//申请退货
    DISPOSE_CHANGE(5),//申请换货
    ;
    public final int afterSaleStatus;

    AfterSaleStatusEnum(int afterSaleStatus) {
        this.afterSaleStatus = afterSaleStatus;
    }

    public static AfterSaleStatusEnum statusOf(int afterSaleStatus) {
        for (AfterSaleStatusEnum afterSaleStatusEnum : values()) {
            if (afterSaleStatusEnum.afterSaleStatus == afterSaleStatus) {
                return afterSaleStatusEnum;
            }
        }
        throw new IllegalArgumentException(String.format("afterSaleStatus %d 不合法", afterSaleStatus));
    }
}
