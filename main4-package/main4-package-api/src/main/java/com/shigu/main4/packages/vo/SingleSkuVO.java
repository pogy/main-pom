package com.shigu.main4.packages.vo;

import java.io.Serializable;

public class SingleSkuVO implements Serializable {
    /**
     * 颜色属性值ID
     */
    private Long colorVid;
    /**
     * 尺码属性值ID
     */
    private Long sizeVid;
    /**
     * 颜色别名
     */
    private String colorAlias;
    /**
     * 尺码别名
     */
    private String sizeAlias;
    /**
     * 库存
     */
    private Integer stockNum;
    /**
     * 独立价格(优先使用该价格)
     */
    private String priceString;

    /**
     * 获取 颜色属性值ID
     */
    public Long getColorVid() {
        return this.colorVid;
    }

    /**
     * 设置 颜色属性值ID
     */
    public void setColorVid(Long colorVid) {
        this.colorVid = colorVid;
    }

    /**
     * 获取 尺码属性值ID
     */
    public Long getSizeVid() {
        return this.sizeVid;
    }

    /**
     * 设置 尺码属性值ID
     */
    public void setSizeVid(Long sizeVid) {
        this.sizeVid = sizeVid;
    }

    /**
     * 获取 颜色别名
     */
    public String getColorAlias() {
        return this.colorAlias;
    }

    /**
     * 设置 颜色别名
     */
    public void setColorAlias(String colorAlias) {
        this.colorAlias = colorAlias;
    }

    /**
     * 获取 尺码别名
     */
    public String getSizeAlias() {
        return this.sizeAlias;
    }

    /**
     * 设置 尺码别名
     */
    public void setSizeAlias(String sizeAlias) {
        this.sizeAlias = sizeAlias;
    }

    /**
     * 获取 库存
     */
    public Integer getStockNum() {
        return this.stockNum;
    }

    /**
     * 设置 库存
     */
    public void setStockNum(Integer stockNum) {
        this.stockNum = stockNum;
    }

    /**
     * 获取 独立价格
     */
    public String getPriceString() {
        return this.priceString;
    }

    /**
     * 设置 独立价格
     */
    public void setPriceString(String priceString) {
        this.priceString = priceString;
    }
}
