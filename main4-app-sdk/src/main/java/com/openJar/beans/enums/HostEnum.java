package com.openJar.beans.enums;

/**
 * 类名：HostEnum
 * 类路径：com.openJar.beans.enums.HostEnum
 * 创建者：王浩翔
 * 创建时间：2017-08-29 12:30
 * 项目：main-pom
 * 描述：
 */
public enum HostEnum {
    APP_TEST_HOST("http://127.0.0.1/app/"),
    APP_REST_HOST("http://www.571xz.com/app/"),
    WAP_TEST_HOST("http://127.0.0.1/wap/"),
    WAP_REST_HOST("http://www.571xz.com/wap/")
    ,
    ;
    private String url;
    HostEnum(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return url;
    }
}
