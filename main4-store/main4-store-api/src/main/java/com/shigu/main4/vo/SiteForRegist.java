package com.shigu.main4.vo;

import java.io.Serializable;

/**
 * 提供给注册的站点
 * Created by zhaohongbo on 17/2/23.
 */
public class SiteForRegist implements Serializable{
    /**
     * 分站名
     */
    private String siteName;
    /**
     * 分站标识
     */
    private String webSite;

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }
}
