package com.shigu.main4.ucenter.enums;

public enum RegistSourceEnum {
    PC(1,"PC端注册"),
    APP_IOS(2,"APP IOS端注册"),
    APP_ANDRION(3,"APP Android端注册"),
    H5(4,"H5端注册"),
    WX_GZH(5,"WX 公众号端注册"),
    WX_XCH(6,"WX 小程序端注册"),


    ;

    public Integer registSource;
    public String context;

    RegistSourceEnum(Integer registSource, String value) {
        this.registSource = registSource;
        this.context = context;
    }

    public static RegistSourceEnum parseReginstSourse(Integer registSource){
        if (registSource == null) {
            return null;
        }
        for (RegistSourceEnum item : RegistSourceEnum.values()){
            if (item.registSource.intValue() == registSource.intValue()) {
                return item;
            }
        }
        return null;
    }


}
