package com.shigu.main4.item.bo.news;

import java.io.Serializable;

/**
 * 独立skuBo创建用对象
 */
public class SingleSkuBO implements Serializable {
    private Long colorPid;
    private Long sizePid;
    /**
     * 颜色属性值ID
     */
    private Long colorVid;
    private String colorVname;
    /**
     * 尺码属性值ID
     */
    private Long sizeVid;
    private String sizeVname;
    /**
     * 颜色别名
     */
    private String colorAlias;
    /**
     * 颜色自定义名
     */
    private String colorInput;
    /**
     * 尺码别名
     */
    private String sizeAlias;
    /**
     * 尺码自定义
     */
    private String sizeInput;
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

    /**
     * 获取 颜色自定义名
     */
    public String getColorInput() {
        return this.colorInput;
    }

    /**
     * 设置 颜色自定义名
     */
    public void setColorInput(String colorInput) {
        this.colorInput = colorInput;
    }

    /**
     * 获取 尺码自定义
     */
    public String getSizeInput() {
        return this.sizeInput;
    }

    /**
     * 设置 尺码自定义
     */
    public void setSizeInput(String sizeInput) {
        this.sizeInput = sizeInput;
    }

    public Long getColorPid() {
        return this.colorPid;
    }

    public void setColorPid(Long colorPid) {
        this.colorPid = colorPid;
    }

    public Long getSizePid() {
        return this.sizePid;
    }

    public void setSizePid(Long sizePid) {
        this.sizePid = sizePid;
    }

    public String getColorVname() {
        return this.colorVname;
    }

    public void setColorVname(String colorVname) {
        this.colorVname = colorVname;
    }

    public String getSizeVname() {
        return this.sizeVname;
    }

    public void setSizeVname(String sizeVname) {
        this.sizeVname = sizeVname;
    }
}
