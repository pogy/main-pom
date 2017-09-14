package com.openJar.enums;

public enum HostEnum {
    TEST("http://127.0.0.1:8080/app/"),REST("http://");

    private String host;
    HostEnum(String host){
        this.host=host;
    }

    public String toString(){
        return this.host;
    }
}
