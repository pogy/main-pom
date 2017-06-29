package com.shigu.spread.vo;

import java.io.Serializable;

/**
 * 图片广告
 * Created by zhaohongbo on 17/4/10.
 */
public class ImgBannerVO implements Serializable{
    private String href;

    private String imgsrc;

    private String text;

    public ImgBannerVO() {
    }

    public ImgBannerVO(String href, String imgsrc, String text) {
        this.href = href;
        this.imgsrc = imgsrc;
        this.text = text;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
