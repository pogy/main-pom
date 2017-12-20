package com.shigu.main4.order.zfenums;

/**
 * Created by zf on 2017/7/17.
 */
public enum UserTypeEnum {
    CUSTOM_SERVICE(0),
    BUYER(1),
    ;

    public final int type;
    UserTypeEnum(int type){
        this.type=type;
    }
    public static UserTypeEnum statusOf(int type) {
        for (UserTypeEnum userTypeEnum : values()) {
            if (userTypeEnum.type == type) {
                return userTypeEnum;
            }
        }
        throw new IllegalArgumentException(String.format("type %d 不合法", type));
    }
}
