package com.shigu.main4.goat.vo;

import java.io.Serializable;

/**
 * 图片类型广告
 *
 * Created by zhaohongbo on 17/5/4.
 */
public class ImgGoatVO extends GoatVO implements Serializable{
    /**
     * 图片链接
     */
    private String picUrl;
    /**
     * 超链接
     */
    private String linkUrl;

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }
}
