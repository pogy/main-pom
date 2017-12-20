package com.shigu.main4.vo.fitment;

import java.io.Serializable;

/**
 * 图片链接 + 跳转地址
 * Created by Administrator on 2017/4/18 0018.
 */
public class ImageInfo implements Serializable {

    private String picUrl;
    private String targetUrl;

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }
}
