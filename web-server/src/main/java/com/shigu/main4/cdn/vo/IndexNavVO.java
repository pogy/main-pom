package com.shigu.main4.cdn.vo;

import java.io.Serializable;

/**
 * 标签
 * Created by zhaohongbo on 17/4/10.
 */
public class IndexNavVO implements Serializable{
    /**
     * 链接
     */
    private String href;
    /**
     * 标题
     */
    private String text;

    public IndexNavVO(String href, String text) {
        this.href = href;
        this.text = text;
    }

    public IndexNavVO(String text,Long cid) {
        this.href = "http://so.571xz.com/hzgoods.htm?pid="+cid+"&keyword="+text;
        this.text = text;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
