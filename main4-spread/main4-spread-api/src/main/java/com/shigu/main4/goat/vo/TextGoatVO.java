package com.shigu.main4.goat.vo;

import java.io.Serializable;

/**
 * 文字形广告
 * Created by zhaohongbo on 17/5/5.
 */
public class TextGoatVO extends GoatVO implements Serializable{
    /**
     * 标题
     */
    private String text;
    /**
     * 链接
     */
    private String href;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
