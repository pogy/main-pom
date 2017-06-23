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
    private Date startOnline;
    /**
     * 广告结束时间
     */
    private Date endOnline;

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

    public Date getStartOnline() {
        return startOnline;
    }

    public void setStartOnline(Date startOnline) {
        this.startOnline = startOnline;
    }

    public Date getEndOnline() {
        return endOnline;
    }

    public void setEndOnline(Date endOnline) {
        this.endOnline = endOnline;
    }
}
