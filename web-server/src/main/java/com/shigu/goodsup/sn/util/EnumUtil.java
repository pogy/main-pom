package com.shigu.goodsup.sn.util;

import com.shigu.goodsup.sn.interfaces.EnumMessage;

public class EnumUtil {
    /**
     * 获取value返回枚举对象
     * @param value
     * @param clazz
     * */
    public static <T extends EnumMessage>  T getEnumObject(Object value, Class<T> clazz){
        return (T) Constant.ENUM_MAP.get(clazz).get(value);
    }
}
