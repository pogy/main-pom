package com.shigu.photo.vo;

import java.io.Serializable;

public class GoatBannerVO implements Serializable {
    private String href;
    private String imgsrc;

    public String getHref() {
        return this.href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getImgsrc() {
        return this.imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }
}
