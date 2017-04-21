package com.shigu.search.vo;

import java.io.Serializable;

/**
 * 风格
 * Created by zhaohongbo on 17/4/5.
 */
public class StyleCateNav implements Serializable{
    /**
     * 类目ID
     */
    private String id;
    /**
     * 类目名称
     */
    private String text;

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
