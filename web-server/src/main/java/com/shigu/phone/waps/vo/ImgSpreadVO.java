package com.shigu.phone.waps.vo;

import java.io.Serializable;

/**
 * Created by Admin on 2017/10/17.
 */
public class ImgSpreadVO implements Serializable {

    private String href;
    private String imgsrc;
    private String text;

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
