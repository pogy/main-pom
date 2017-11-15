package com.openJar.enums;

public enum HostEnum {

//    TEST("http://60.190.245.70:5060/app/"),REST("http://appinterface.571xz.com/app/");//193上
//    TEST("http://appinterface.571xz.com/app/"),REST("http://www.571xz.com/app/");//193上
//    TEST("http://cusm2y.natappfree.cc/app/"),REST("http://www.571xz.com/app/");//内网穿透
    TEST("http://127.0.0.1:8080/app/"),REST("http://");//本地

    //本地    http://127.0.0.1:8080/app/
    private String host;
    HostEnum(String host){
        this.host=host;
    }

    public String toString(){
        return this.host;
    }
}
