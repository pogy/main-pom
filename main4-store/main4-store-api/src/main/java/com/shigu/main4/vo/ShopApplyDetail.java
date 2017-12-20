package com.shigu.main4.vo;

import com.shigu.main4.common.vo.ShiguTags;

import java.io.Serializable;
import java.util.List;

/**
 * 开店申请详细信息
 * Created by zhaohongbo on 17/3/14.
 */
public class ShopApplyDetail implements Serializable {
    /**
     * 入驻ID
     */
    private Long ruzhuId;
    /**
     * 主营类目
     */
    private String mainBus;
    /**
     * 淘宝昵称
     */
    private String tbNick;
    /**
     * 淘宝链接
     */
    private String tbUrl;
    /**
     * 手机号
     */
    private String telephone;
    /**
     * 微信
     */
    private String imWx;
    /**
     * QQ
     */
    private String imQq;
    /**
     * 邮箱
     */
    private String email;

    /**
     * 分站标识
     */
    private String webSite;
    /**
     * 市场名称
     */
    private String market;
    /**
     * 市场ID
     */
    private Long marketId;
    /**
     * 楼层
     */
    private String floor;
    /**
     * 楼层ID
     */
    private Long floorId;
    /**
     * 档口号
     */
    private String shopNum;
    /**
     * 退换标签
     */
    private List<ShiguTags> tagsList;
    /**
     * 审核不通过原因
     */
    private String reason;

    public Long getRuzhuId() {
        return ruzhuId;
    }

    public void setRuzhuId(Long ruzhuId) {
        this.ruzhuId = ruzhuId;
    }

    public String getMainBus() {
        return mainBus;
    }

    public void setMainBus(String mainBus) {
        this.mainBus = mainBus;
    }

    public String getTbNick() {
        return tbNick;
    }

    public void setTbNick(String tbNick) {
        this.tbNick = tbNick;
    }

    public String getTbUrl() {
        return tbUrl;
    }

    public void setTbUrl(String tbUrl) {
        this.tbUrl = tbUrl;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getImWx() {
        return imWx;
    }

    public void setImWx(String imWx) {
        this.imWx = imWx;
    }

    public String getImQq() {
        return imQq;
    }

    public void setImQq(String imQq) {
        this.imQq = imQq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public Long getMarketId() {
        return marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public Long getFloorId() {
        return floorId;
    }

    public void setFloorId(Long floorId) {
        this.floorId = floorId;
    }

    public String getShopNum() {
        return shopNum;
    }

    public void setShopNum(String shopNum) {
        this.shopNum = shopNum;
    }

    public List<ShiguTags> getTagsList() {
        return tagsList;
    }

    public void setTagsList(List<ShiguTags> tagsList) {
        this.tagsList = tagsList;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
