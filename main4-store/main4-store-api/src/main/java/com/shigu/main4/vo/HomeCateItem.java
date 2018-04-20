package com.shigu.main4.vo;

import java.io.Serializable;

public class HomeCateItem implements Serializable{
    private String name;
    private String href;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
    public HomeCateItem(){
        
    }
    public HomeCateItem(String name, String href) {
        this.name = name;
        this.href = href;
    }
}
