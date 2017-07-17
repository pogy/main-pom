package com.shigu.main4.order.enums;

/**
 * Created by zf on 2017/7/17.
 */
public enum UserTypeEnum {
    BUYER(0),
    CUSTOM_SERVICE(1),
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
