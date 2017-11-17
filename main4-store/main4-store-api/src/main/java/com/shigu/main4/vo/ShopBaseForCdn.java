package com.shigu.main4.vo;

import java.io.Serializable;

/**
 * 店铺基本信息,给店铺页面展示的
 * Created by zhaohongbo on 17/2/22.
 */
public class ShopBaseForCdn implements Serializable{
    /**
     * 主营类目
     */
    private String mainBus;
    /**
     * 开店时间 default format : yyyy-MM-dd
     */
    private String openTime;
    /**
     * 数据包链接
     */
    private String dataPackageUrl;
    /**
     * 淘宝店链接
     */
    private String taobaoUrl;
    /**
     * 店铺类型
     */
    private Integer type;

    public String getTaobaoUrl() {
        return taobaoUrl;
    }

    public void setTaobaoUrl(String taobaoUrl) {
        this.taobaoUrl = taobaoUrl;
    }

    public String getDataPackageUrl() {
        return dataPackageUrl;
    }

    public void setDataPackageUrl(String dataPackageUrl) {
        this.dataPackageUrl = dataPackageUrl;
    }

    public String getMainBus() {
        return mainBus;
    }

    public void setMainBus(String mainBus) {
        this.mainBus = mainBus;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
