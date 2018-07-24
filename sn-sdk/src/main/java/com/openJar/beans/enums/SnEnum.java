package com.openJar.beans.enums;

import java.io.Serializable;

public enum SnEnum implements Serializable{
    REST("http://sn.571xz.com/");

    SnEnum(String url){
        this.url=url;
    }

    @Override
    public String toString(){
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
