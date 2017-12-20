package com.shigu.main4.vo.fitment;

import java.io.Serializable;

/**
 * 自定义导航
 * Created by Administrator on 2017/4/18 0018.
 */
public class BannerAuto implements Serializable {

    private String name;

    private String targetUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }
}
