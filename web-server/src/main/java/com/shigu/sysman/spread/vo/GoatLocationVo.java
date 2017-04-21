package com.shigu.sysman.spread.vo;


import java.util.Date;

/**
 *
 *
 */
public class GoatLocationVo {

    private Long localId;
    /**
     * 广告编号
     */
    private String localCode;
    /**
     * 广告地址区域code
     */
    private String localAreaCode;
    /**
     * 是否线下广告
     */
    private Boolean underLine;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 是否禁用
     */
    private Boolean disEnabled;
    /**
     * 1普通广告（有模板）、2商品类广告、3店铺类广告
     */
    private Integer type;

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

    public Boolean getUnderLine() {
        return underLine;
    }

    public void setUnderLine(Boolean underLine) {
        this.underLine = underLine;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getLocalAreaCode() {
        return localAreaCode;
    }

    public void setLocalAreaCode(String localAreaCode) {
        this.localAreaCode = localAreaCode;
    }
}
