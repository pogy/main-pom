package com.openJar.enums;

public enum HostEnum {
    //服务器   http://192.168.1.193:5050/app/

    //TEST("http://192.168.1.193:5060/app/"),REST("http://");
    TEST("http://appinterface.571xz.com"),REST("http://");
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
