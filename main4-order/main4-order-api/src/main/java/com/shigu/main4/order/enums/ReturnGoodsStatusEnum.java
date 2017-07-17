package com.shigu.main4.order.enums;

/**
 * Created by zf on 2017/7/17.
 */
public enum ReturnGoodsStatusEnum {
    DISPOSE_RETRUN_GOODS(0),//申请售后
    WAIT_PROCESS(1),//等待申请处理
    RETURN_GOODS(2),//买家退货
    RETURN_ENT(3)//退款
    ;
    public final int returnGoodsStatus;

    ReturnGoodsStatusEnum(int returnGoodsStatus) {
        this.returnGoodsStatus = returnGoodsStatus;
    }

    public static ReturnGoodsStatusEnum statusOf(int returnGoodsStatus) {
        for (ReturnGoodsStatusEnum returnGoodsStatusEnum : values()) {
            if (returnGoodsStatusEnum.returnGoodsStatus == returnGoodsStatus) {
                return returnGoodsStatusEnum;
            }
        }
        throw new IllegalArgumentException(String.format("returnGoodsStatus %d 不合法", returnGoodsStatus));
    }
}
