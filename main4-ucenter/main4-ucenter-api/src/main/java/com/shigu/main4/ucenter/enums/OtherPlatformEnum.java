package com.shigu.main4.ucenter.enums;

public enum OtherPlatformEnum {
    BIND_PHONE("绑定手机","__bindPhone__"),
    MORE_ORDER("订单批量操作","__moreOrder__")

    ;

    private String value;
    private String context;

    OtherPlatformEnum(String context, String value) {
        this.value = value;
        this.context = context;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getContext() {
        return this.context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
