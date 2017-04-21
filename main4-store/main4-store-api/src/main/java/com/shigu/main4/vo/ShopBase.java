package com.shigu.main4.vo;

import java.io.Serializable;

/**
 * 修改店铺基本信息
 * Created by zhaohongbo on 17/2/28.
 */
public class ShopBase implements Serializable{
    /**
     * 档口号
     */
    private String shopNum;
    /**
     * 店名
     */
    private String shopName;

    /**
     * 主营类目
     */
    private String mainBus;
    /**
     * 数据包链接
     */
    private String dataPackageUrl;
    /**
     * 淘宝昵称
     */
    private String tbNick;
    /**
     * 淘宝店链接
     */
    private String taobaoUrl;

    /**
     * 系统备注
     */
    private String systemRecommon;

    public String getShopNum() {
        return shopNum;
    }

    public void setShopNum(String shopNum) {
        this.shopNum = shopNum;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getMainBus() {
        return mainBus;
    }

    public void setMainBus(String mainBus) {
        this.mainBus = mainBus;
    }

    public String getDataPackageUrl() {
        return dataPackageUrl;
    }

    public void setDataPackageUrl(String dataPackageUrl) {
        this.dataPackageUrl = dataPackageUrl;
    }

    public String getTbNick() {
        return tbNick;
    }

    public void setTbNick(String tbNick) {
        this.tbNick = tbNick;
    }

    public String getTaobaoUrl() {
        return taobaoUrl;
    }

    public void setTaobaoUrl(String taobaoUrl) {
        this.taobaoUrl = taobaoUrl;
    }

    public String getSystemRecommon() {
        return systemRecommon;
    }

    public void setSystemRecommon(String systemRecommon) {
        this.systemRecommon = systemRecommon;
    }
}
