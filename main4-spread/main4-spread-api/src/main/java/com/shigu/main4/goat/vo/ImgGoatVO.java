package com.shigu.main4.goat.vo;

/**
 * 图片类型广告
 *
 * Created by zhaohongbo on 17/5/4.
 */
public class ImgGoatVO extends GoatVO{
    /**
     * 图片链接
     */
    private String picUrl;
    /**
     * 超链接
     */
    private String linkUrl;

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
