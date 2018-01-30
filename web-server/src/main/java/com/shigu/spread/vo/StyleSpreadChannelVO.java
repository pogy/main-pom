package com.shigu.spread.vo;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * 路径:com.shigu.spread.vo.StyleSpreadChannelVO
 * 工程:main-pom
 * 时间:18-1-29下午12:26
 * 创建人:wanghaoxiang
 * 描述：获取风格的广告标签
 */
public class StyleSpreadChannelVO implements Serializable {
    //风格id，目前广告相对于顶级风格
    private Long styleId;
    //广告标志
    private String spreadTag;
    //分站
    private String webSite;

    //错误标签
    public static final String ERROR_TAG = "STYLE_CHANNEL_ERROR_TAG";

    public String bannerTag() {
        if (styleId == null || StringUtils.isBlank(spreadTag)) {
            return ERROR_TAG;
        }
        return "STYLE_CHANNEL_BANNER_" + spreadTag;
    }

    public String goatShopTag() {
        if (styleId == null || StringUtils.isBlank(spreadTag)) {
            return ERROR_TAG;
        }
        return "STYLE_CHANNEL_GOAT_SHOP_" + spreadTag;
    }

    public String hotStyleTag() {
        if (styleId == null || StringUtils.isBlank(spreadTag)) {
            return ERROR_TAG;
        }
        return "STYLE_CHANNEL_HOT_STYLE_" + spreadTag;
    }

    public String recommendTag() {
        if (styleId == null || StringUtils.isBlank(spreadTag)) {
            return ERROR_TAG;
        }
        return "STYLE_CHANNEL_RECOMMEND_" + spreadTag;
    }

    public void setStyleId(Long styleId) {
        this.styleId = styleId;
    }

    public void setSpreadTag(String spreadTag) {
        this.spreadTag = spreadTag;
    }

    public String getWebSite() {
        if (StringUtils.isBlank(webSite)) {
            webSite = "hz";
        }
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public Long getStyleId() {
        return styleId;
    }
}
