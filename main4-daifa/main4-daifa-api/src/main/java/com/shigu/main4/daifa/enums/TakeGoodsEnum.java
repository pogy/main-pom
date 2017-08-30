package com.shigu.main4.daifa.enums;

/**
 * 拿货状态
 * Created by zhaohongbo on 17/8/9.
 */
public enum TakeGoodsEnum {
    DEFAULT(0),//拿货中
    HAS_TAKE(1),//已拿
    NO_GOODS(2),//缺货
    ;

    TakeGoodsEnum(Integer value) {
        this.value = value;
    }

    private Integer value;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
