package com.openJar.beans.enums;

import java.io.Serializable;

/**
 * 接口链接用
 * Created by zhaohongbo on 16/12/20.
 */
public enum JdImgEnum implements Serializable{
    TEST("http://zs.571xz.com/jdImgApi/"),REST("http://zs.571xz.com/jdImgApi/");

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
