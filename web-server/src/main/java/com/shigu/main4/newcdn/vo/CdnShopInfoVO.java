package com.shigu.main4.newcdn.vo;

import java.util.List;

/**
 * Created by zf on 2017/7/25.
 */
public class CdnShopInfoVO {
    /**
     * 档口ID
     */
    private Long shopId;
    /**
     * 档口号
     */
    private String shopNo;
    /**
     * 市场名
     */
    private String marketName;
    /**
     * 楼层
     */
    private String floor;
    /**
     * qq
     */
    private String imQq;
    /**
     * 旺旺
     */
    private String imWw;
    /**
     * 档口二级域名
     */
    private String xzUrl;
    /**
     * 主营类目
     */
    private String mainBus;
    /**
     * 开店时间 yyyy-MM-dd
     */
    private String openTime;
    /**
     * 是否实体认证
     */
    private Boolean isStrz;
    /**
     * 淘宝授权状态，0（未授权），1（同步授权），2（授权过期）
     */
    private Integer tbAuthState;
    /**
     * 星星数
     */
    private Long starNum;

    /**
     * 获取 档口ID
     */
    public Long getShopId() {
        return this.shopId;
    }

    /**
     * 设置 档口ID
     */
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    /**
     * 获取 档口号
     */
    public String getShopNo() {
        return this.shopNo;
    }

    /**
     * 设置 档口号
     */
    public void setShopNo(String shopNo) {
        this.shopNo = shopNo;
    }

    /**
     * 获取 市场名
     */
    public String getMarketName() {
        return this.marketName;
    }

    /**
     * 设置 市场名
     */
    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    /**
     * 获取 楼层
     */
    public String getFloor() {
        return this.floor;
    }

    /**
     * 设置 楼层
     */
    public void setFloor(String floor) {
        this.floor = floor;
    }

    /**
     * 获取 qq
     */
    public String getImQq() {
        return this.imQq;
    }

    /**
     * 设置 qq
     */
    public void setImQq(String imQq) {
        this.imQq = imQq;
    }

    /**
     * 获取 旺旺
     */
    public String getImWw() {
        return this.imWw;
    }

    /**
     * 设置 旺旺
     */
    public void setImWw(String imWw) {
        this.imWw = imWw;
    }

    /**
     * 获取 档口二级域名
     */
    public String getXzUrl() {
        return this.xzUrl;
    }

    /**
     * 设置 档口二级域名
     */
    public void setXzUrl(String xzUrl) {
        this.xzUrl = xzUrl;
    }

    /**
     * 获取 主营类目
     */
    public String getMainBus() {
        return this.mainBus;
    }

    /**
     * 设置 主营类目
     */
    public void setMainBus(String mainBus) {
        this.mainBus = mainBus;
    }

    /**
     * 获取 开店时间 yyyy-MM-dd
     */
    public String getOpenTime() {
        return this.openTime;
    }

    /**
     * 设置 开店时间 yyyy-MM-dd
     */
    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    /**
     * 获取 淘宝授权状态，0（未授权），1（同步授权），2（授权过期）
     */
    public Integer getTbAuthState() {
        return this.tbAuthState;
    }

    /**
     * 设置 淘宝授权状态，0（未授权），1（同步授权），2（授权过期）
     */
    public void setTbAuthState(Integer tbAuthState) {
        this.tbAuthState = tbAuthState;
    }

    /**
     * 获取 是否实体认证
     */
    public Boolean getIsStrz() {
        return this.isStrz;
    }

    /**
     * 设置 是否实体认证
     */
    public void setIsStrz(Boolean isStrz) {
        this.isStrz = isStrz;
    }

    /**
     * 获取 星星数
     */
    public Long getStarNum() {
        return this.starNum;
    }

    /**
     * 设置 星星数
     */
    public void setStarNum(Long starNum) {
        this.starNum = starNum;
    }
}
