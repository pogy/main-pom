package com.shigu.main4.photo.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 作品列表
 */
public class PhotoWorksAuthVO implements Serializable{
    private Long worksAuthId;
    private String picUrl;
    private String images;
    private Integer authStatus;
    private String msg;

    public Long getWorksAuthId() {
        return this.worksAuthId;
    }

    public void setWorksAuthId(Long worksAuthId) {
        this.worksAuthId = worksAuthId;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getImages() {
        return this.images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Integer getAuthStatus() {
        return this.authStatus;
    }

    public void setAuthStatus(Integer authStatus) {
        this.authStatus = authStatus;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
