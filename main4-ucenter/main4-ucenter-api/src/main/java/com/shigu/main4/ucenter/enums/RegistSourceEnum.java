package com.shigu.main4.ucenter.enums;

public enum RegistSourceEnum {
    PC(1,"PC端注册"),
    APP(2,"APP端注册"),
    H5(3,"H5端注册"),
    WX(4,"WX端注册"),

    ;

    public Integer registSource;
    public String context;

    RegistSourceEnum(Integer registSource, String value) {
        this.registSource = registSource;
        this.context = context;
    }

}
