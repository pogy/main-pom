package com.shigu.main4.vo;

import java.io.Serializable;

/**
 * 店铺联系方式基础类
 * Created by zhaohongbo on 17/2/8.
 */
public class StoreRelation implements Serializable{
    /**
     * 市场名称
     */
    private String marketName;
    /**
     * 楼层
     */
    private String floor;
    /**
     * 店铺ID,主键
     */
    private Long storeId;
    /**
     * 档口号
     */
    private String storeNum;
    /**
     * 手机号
     */
    private String telephone;
    /**
     * QQ号
     */
    private String imQq;
    /**
     * 旺旺号
     */
    private String imWw;
    /**
     * 微信号
     */
    private String imWx;
    /**
     * 分站标识
     */
    private String webSite;

    /**
     * 市场ID
     * @return
     */
    private Long marketId;

    public Long getMarketId() {
        return marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getStoreNum() {
        return storeNum;
    }

    public void setStoreNum(String storeNum) {
        this.storeNum = storeNum;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getImQq() {
        return imQq;
    }

    public void setImQq(String imQq) {
        this.imQq = imQq;
    }

    public String getImWw() {
        return imWw;
    }

    public void setImWw(String imWw) {
        this.imWw = imWw;
    }

    public String getImWx() {
        return imWx;
    }

    public void setImWx(String imWx) {
        this.imWx = imWx;
    }
}
