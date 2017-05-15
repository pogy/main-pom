package com.shigu.main4.vo;

import java.io.Serializable;

/**
 * 店铺注册信息
 * Created by Licca on 17/2/20.
 */
public class ShopRegister implements Serializable {
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 主营类目
     */
    private String mainBus;
    /**
     * 档口号
     */
    private String shopNum;
    /**
     * 可审核
     * 当用户选择有淘宝店时
     * 此值为false，管理后台不可见
     * 在淘宝授权完毕以后，自动把此值改为true,管理后台可见
     */
    private boolean canExamine;
    /**
     * 联系电话
     */
    private String telephone;
    /**
     * 微信号
     */
    private String imWx;
    /**
     * QQ号
     */
    private String imQq;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 分站
     */
    private String webSite;
    /**
     * 市场Id
     */
    private Long marketId;
    /**
     * 楼层Id
     */
    private Long floorId;
    /**
     * 退换服务标签
     */
    private String tags;
    /**
     * 申请者的IP
     */
    private String ip;
    /**
     * 淘宝店ID
     */
    private String tbshopId;
    /**
     * 淘宝用户ID
     */
    private String tbUserId;
    /**
     * 淘宝昵称
     */
    private String tbNick;
    /**
     * 淘宝店链接
     */
    private String tbUrl;
    /**
     * 阿里旺旺
     */
    private String imAliww;

    public String getImAliww() {
        return imAliww;
    }

    public void setImAliww(String imAliww) {
        this.imAliww = imAliww;
    }

    public String getTbNick() {
        return tbNick;
    }

    public void setTbNick(String tbNick) {
        this.tbNick = tbNick;
    }

    public String getTbshopId() {
        return tbshopId;
    }

    public void setTbshopId(String tbshopId) {
        this.tbshopId = tbshopId;
    }

    public String getTbUrl() {
        return tbUrl;
    }

    public void setTbUrl(String tbUrl) {
        this.tbUrl = tbUrl;
    }

    public String getTbUserId() {
        return tbUserId;
    }

    public void setTbUserId(String tbUserId) {
        this.tbUserId = tbUserId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public boolean isCanExamine() {
        return canExamine;
    }

    public void setCanExamine(boolean canExamine) {
        this.canExamine = canExamine;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getFloorId() {
        return floorId;
    }

    public void setFloorId(Long floorId) {
        this.floorId = floorId;
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

    public String getMainBus() {
        return mainBus;
    }

    public void setMainBus(String mainBus) {
        this.mainBus = mainBus;
    }

    public Long getMarketId() {
        return marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }

    public String getShopNum() {
        return shopNum;
    }

    public void setShopNum(String shopNum) {
        this.shopNum = shopNum;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }
}
