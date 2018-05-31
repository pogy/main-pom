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
    public CateNav(String id, String text, String keyword,String cname) {
        this.id = id;
        this.text = text;
        this.keyword = keyword;
        this.cname = cname;
    }

    private String id;

    private String text;

    private String cname;

    private String keyword;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

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
