package com.shigu.seller.vo;

import java.util.Date;

/**
 * Created by whx on 2017/6/22 0022.
 */
public class IndexGoatVO {
    /**
     * 广告类型 热卖/推荐档口等
     */
    private String type;
    /**
     * 广告ID
     */
    private Long codeId;
    /**
     * 广告编号
     */
    private String code;
    /**
     * 商品分站
     */
    private String webSite;
    /**
     * 广告商品首图
     */
    private String picUrl;
    /**
     * 广告开始时间
     */
    private String startOnline;
    /**
     * 广告结束时间
     */
    private String endOnline;
    /**
     * 广告发布时段
     */
    private String goatTime;

    public String getGoatTime() {
        return goatTime;
    }

    public void setGoatTime(String goatTime) {
        this.goatTime = goatTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getCodeId() {
        return codeId;
    }

    public void setCodeId(Long codeId) {
        this.codeId = codeId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getStartOnline() {
        return startOnline;
    }

    public void setStartOnline(String startOnline) {
        this.startOnline = startOnline;
    }

    public String getEndOnline() {
        return endOnline;
    }

    public void setEndOnline(String endOnline) {
        this.endOnline = endOnline;
    }
}
