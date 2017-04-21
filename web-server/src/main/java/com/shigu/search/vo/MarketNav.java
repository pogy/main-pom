package com.shigu.search.vo;

import java.io.Serializable;

/**
 * 档口搜索中的市场列表
 * Created by zhaohongbo on 17/4/5.
 */
public class MarketNav implements Serializable{

    private String id;

    private String text;

    public MarketNav(String id, String text) {
        this.id = id;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
