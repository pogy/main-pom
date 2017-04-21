package com.shigu.search.vo;

import java.io.Serializable;

/**
 * 类目栏
 * Created by zhaohongbo on 17/4/6.
 */
public class CateNav implements Serializable{

    public CateNav(String id, String text) {
        this.id = id;
        this.text = text;
    }

    public CateNav(String id, String text, String keyword) {
        this.id = id;
        this.text = text;
        this.keyword = keyword;
    }

    private String id;

    private String text;

    private String keyword;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
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
