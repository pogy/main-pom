package com.shigu.main4.order.zfenums;

/**
 * Created by zf on 2017/7/24.
 */
public enum ShStatusEnum {
    REFUND(1),//退货退款
    CHANGE(2);//换货

    public final int shStatus;
    ShStatusEnum(Integer shStatus){
        this.shStatus=shStatus;
    }
    public static ShStatusEnum statusOf(int shStatus) {
        for (ShStatusEnum shStatusEnum : values()) {
            if (shStatusEnum.shStatus == shStatus) {
                return shStatusEnum;
            }
        }
        throw new IllegalArgumentException(String.format("shStatus %d 不合法", shStatus));
    }

}
