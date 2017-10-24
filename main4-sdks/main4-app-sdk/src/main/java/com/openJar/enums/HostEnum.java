package com.openJar.enums;

public enum HostEnum {

    TEST("http://appinterface.571xz.com/app/"),REST("http://www.571xz.com/app/");
//    TEST("http://127.0.0.1:8080/app/"),REST("http://");

    //本地    http://127.0.0.1:8080/app/
    private String host;
    HostEnum(String host){
        this.host=host;
    }

    public String toString(){
        return this.host;
    }
}
