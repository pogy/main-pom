package com.shigu.seller.bo;

import org.hibernate.validator.constraints.SafeHtml;

import java.io.Serializable;

/**
 * 保存店铺基本设置
 * Created by zhaohongbo on 17/3/18.
 */
public class ShopBaseBO implements Serializable{

    @SafeHtml(message = "mainBus包含非法页面标签")
    private String mainBus;

    @SafeHtml(message = "servers包含非法页面标签")
    private String servers;

    @SafeHtml(message = "storeNum包含非法页面标签")
    private String storeNum;

    @SafeHtml(message = "storeName包含非法页面标签")
    private String storeName;

    @SafeHtml(message = "telephone包含非法页面标签")
    private String telephone;

    @SafeHtml(message = "imWw包含非法页面标签")
    private String imWw;

    @SafeHtml(message = "imQq包含非法页面标签")
    private String imQq;

    @SafeHtml(message = "goodsIds包含非法页面标签")
    private String imWx;

    @SafeHtml(message = "goodsIds包含非法页面标签")
    private String packetUrl;

    @SafeHtml(message = "goodsIds包含非法页面标签")
    private String smallTitle;

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMainBus() {
        return mainBus;
    }

    public void setMainBus(String mainBus) {
        this.mainBus = mainBus;
    }

    public String getServers() {
        return servers;
    }

    public void setServers(String servers) {
        this.servers = servers;
    }

    public String getStoreNum() {
        return storeNum;
    }

    public void setStoreNum(String storeNum) {
        this.storeNum = storeNum;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getImWw() {
        return imWw;
    }

    public void setImWw(String imWw) {
        this.imWw = imWw;
    }

    public String getImQq() {
        return imQq;
    }

    public void setImQq(String imQq) {
        this.imQq = imQq;
    }

    public String getImWx() {
        return imWx;
    }

    public void setImWx(String imWx) {
        this.imWx = imWx;
    }

    public String getPacketUrl() {
        return packetUrl;
    }

    public void setPacketUrl(String packetUrl) {
        this.packetUrl = packetUrl;
    }

    public String getSmallTitle() {
        return smallTitle;
    }

    public void setSmallTitle(String smallTitle) {
        this.smallTitle = smallTitle;
    }
}
