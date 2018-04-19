package com.shigu.main4.ucenter.util;

public class InputSubBean {
    private String key;
    private String value;

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void put(String key,String value){
        this.key=key;
        this.value=value;
    }
}
