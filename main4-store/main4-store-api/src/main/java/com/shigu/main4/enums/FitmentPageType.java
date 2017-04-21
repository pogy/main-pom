package com.shigu.main4.enums;

/**
 * 装修页面类型
 * Created by Administrator on 2017/4/19 0019.
 */
public enum FitmentPageType {

    INDEX("首页"),
    SEARCH("搜索页"),
    CUSTOM("自定义");

    public String name;
    public int value;
    FitmentPageType(String name) {
        this.name = name;
        this.value = this.ordinal() + 1;
    }

    public static FitmentPageType typeOf(Integer type) {
        return values()[type - 1];
    }
}
