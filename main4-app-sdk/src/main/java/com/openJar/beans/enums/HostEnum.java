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
    APP_HOST("http://www.571xz.com/app/","http://127.0.0.1/app/"),
    WAP_HOST("http://www.571xz.com/wap/","http://127.0.0.1/wap/")
    ,
    ;
    private String restUrl;
    private String testUrl;
    HostEnum(String restUrl, String testUrl) {
        this.restUrl = restUrl;
        this.testUrl = testUrl;
    }

    @Override
    public String toString() {
        return restUrl;
    }

    public String getTestUrl() {
        return testUrl;
    }

    public String getRestUrl() {
        return restUrl;
    }
}
