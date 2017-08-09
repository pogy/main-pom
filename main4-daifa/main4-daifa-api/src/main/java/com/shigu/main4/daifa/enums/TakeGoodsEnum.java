package com.shigu.main4.daifa.enums;

/**
 * 拿货状态
 * Created by zhaohongbo on 17/8/9.
 */
public enum TakeGoodsEnum {
    DEFAULT(1),//未拿
    HAS_TAKE(2),//已拿
    NO_GOODS(3),//缺货
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
