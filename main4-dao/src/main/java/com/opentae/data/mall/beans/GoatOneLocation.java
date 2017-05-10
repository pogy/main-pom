package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 广告位置
 * Created by zhaohongbo on 17/5/5.
 */
public class GoatOneLocation {
    /**
     * 广告位置ID
     */
    @Id
    @GeneratedValue(generator="JDBC")
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
    /**
     * 广告类型，0图片广告，1商品广告，2文字广告
     */
    private Integer goatType;

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

    public Integer getGoatType() {
        return goatType;
    }

    public void setGoatType(Integer goatType) {
        this.goatType = goatType;
    }
}
