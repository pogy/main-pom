package com.shigu.main4.cdn.bo;

import java.io.Serializable;

/**
 * 路径:com.shigu.main4.cdn.bo.StyleChannelRecommendBO
 * 工程:main-pom
 * 时间:18-1-26下午12:02
 * 创建人:wanghaoxiang
 * 描述：
 */
public class StyleChannelSearchBO implements Serializable {

    //当前站点id
    private String webSite;
    //风格大类id
    private Long spid;

    public String getWebSite() {
        if (webSite == null) {
            webSite = "hz";
        }
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public Long getSpid() {
        return spid;
    }

    public void setSpid(Long spid) {
        this.spid = spid;
    }
}
