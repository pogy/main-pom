package com.shigu.main4.order.enums;

/**
 * Created by zf on 2017/7/17.
 */
public enum RetrunbleStatusEnum {
    AGREE_PROCESS(0),//同意申请
    EXPRESS_SUBMIT(1),//已提交快递
    GOODS_RECEIVERED(2)//收到货
    ;
    public final int retrunbleStatus;

    RetrunbleStatusEnum(int retrunbleStatus) {
        this.retrunbleStatus = retrunbleStatus;
    }

    public static RetrunbleStatusEnum statusOf(int retrunbleStatus) {
        for (RetrunbleStatusEnum retrunbleStatusEnum : values()) {
            if (retrunbleStatusEnum.retrunbleStatus == retrunbleStatus) {
                return retrunbleStatusEnum;
            }
        }
        throw new IllegalArgumentException(String.format("retrunbleStatus %d 不合法", retrunbleStatus));
    }
}
