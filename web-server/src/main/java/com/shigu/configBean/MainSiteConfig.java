package com.shigu.configBean;

/**
 * 路径: com.shigu.configBean.MainSiteConfig
 * 工程: main-pom
 * 时间: 18-5-15 下午12:53
 * 创建人: wanghaoxiang
 * 描述: 星座网主站配置
 */
public class MainSiteConfig {

    //主站域名
    private String mainSiteDomain;

    //第三方登陆帐号星座网绑定
    private String phoneBindUrl;


    public String getMainSiteDomain() {
        return mainSiteDomain;
    }

    public void setMainSiteDomain(String mainSiteDomain) {
        this.mainSiteDomain = mainSiteDomain;
    }

    public String getPhoneBindUrl() {
        return phoneBindUrl;
    }

    public void setPhoneBindUrl(String phoneBindUrl) {
        this.phoneBindUrl = phoneBindUrl;
    }
}
