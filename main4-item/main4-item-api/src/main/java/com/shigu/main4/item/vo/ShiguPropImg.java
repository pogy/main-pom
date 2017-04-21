package com.shigu.main4.item.vo;

import java.io.Serializable;

/**
 * 商品属性图
 * Created by zhaohongbo on 17/2/23.
 */
public class ShiguPropImg implements Serializable{
    /**
     * 属性ID
     */
    private Long pid;
    /**
     * 属性值ID
     */
    private Long vid;
    /**
     * 属性图链接
     */
    private String url;

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getVid() {
        return vid;
    }

    public void setVid(Long vid) {
        this.vid = vid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
