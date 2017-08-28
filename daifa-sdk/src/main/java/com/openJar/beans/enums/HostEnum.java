package com.openJar.beans.enums;

/**
 * 域
 * Created by zhaohongbo on 16/6/28.
 */
public enum HostEnum {
    //TEST_HOST("http://127.0.0.1:8080/daifa5/api/"),
    TEST_HOST("http://127.0.0.1/api/"),

    REST_HOST("http://daifa.571xz.com/api/");

    HostEnum(String url) {
        this.url=url;
    }

    private String url;

    @Override
    public String toString() {
        return url;
    }
}
