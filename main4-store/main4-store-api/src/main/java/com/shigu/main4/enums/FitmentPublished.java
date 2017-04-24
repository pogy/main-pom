package com.shigu.main4.enums;

/**
 * 已发布的ftl类型
 * Created by zhaohongbo on 17/4/24.
 */
public enum FitmentPublished {

    BANNER("banner"),
    PAGE("page");
    public String name;
    public int value;
    FitmentPublished(String name) {
        this.name = name;
        this.value = this.ordinal() + 1;
    }

    public static FitmentPublished typeOf(Integer type) {
        return values()[type - 1];
    }
}
