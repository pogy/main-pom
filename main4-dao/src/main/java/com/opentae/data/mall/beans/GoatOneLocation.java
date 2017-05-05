package com.opentae.data.mall.beans;

import java.util.Date;

/**
 * 广告位置
 * Created by zhaohongbo on 17/5/5.
 */
public class GoatOneLocation {
    /**
     * 广告位置ID
     */
    private Long localId;
    /**
     * 广告位编号
     */
    private String localCode;
    /**
     * 描述
     */
    private String description;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 是否禁用,true为禁用
     */
    private Boolean disEnabled;
    /**
     * 分站标识
     */
    private String webSite;

    public Long getLocalId() {
        return localId;
    }

    public void setLocalId(Long localId) {
        this.localId = localId;
    }

    public String getLocalCode() {
        return localCode;
    }

    public void setLocalCode(String localCode) {
        this.localCode = localCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getDisEnabled() {
        return disEnabled;
    }

    public void setDisEnabled(Boolean disEnabled) {
        this.disEnabled = disEnabled;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }
}
