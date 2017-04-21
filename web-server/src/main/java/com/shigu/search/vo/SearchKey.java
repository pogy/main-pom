package com.shigu.search.vo;

/**
 * 搜索关键条件
 * Created by zhaohongbo on 17/4/6.
 */
public class SearchKey {
    /**
     * 类目名
     */
    private String text;
    /**
     * 链接
     */
    private String href;

    public SearchKey(String text, String href) {
        this.text = text;
        this.href = href;
    }

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
