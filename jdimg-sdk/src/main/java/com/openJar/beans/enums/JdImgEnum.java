package com.openJar.beans.enums;

import java.io.Serializable;

/**
 * 接口链接用
 * Created by zhaohongbo on 16/12/20.
 */
public enum JdImgEnum implements Serializable{
//    TEST("http://zs.571xz.com:8082/"),REST("http://zs.571xz.com/");
//    TEST("http://zs.571xz.com:8082/"),REST("http://zs.571xz.com:8082/");
    TEST("http://127.0.0.1:8080/"),REST("http://127.0.0.1:8080/");

    JdImgEnum(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return url;
    }

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
