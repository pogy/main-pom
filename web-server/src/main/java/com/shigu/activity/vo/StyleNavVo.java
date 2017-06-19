package com.shigu.activity.vo;

import java.io.Serializable;

/**
 * 风格馆导航数据
 * Created by bugzy on 2017/5/18 0018.
 */
public class StyleNavVo implements Serializable {
    private String id;
    private String text;

    public StyleNavVo(String id, String text) {
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
