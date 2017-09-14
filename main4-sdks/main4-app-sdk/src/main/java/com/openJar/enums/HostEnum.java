package com.openJar.enums;

public enum HostEnum {
    TEST("http://www.571xz.com/app/"),REST("http://");

    private String host;
    HostEnum(String host){
        this.host=host;
    }

    public String toString(){
        return this.host;
    }
}
