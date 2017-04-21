package com.shigu.main4.vo;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * 在es中shop对象
 * Created by zhaohongbo on 17/4/4.
 */
public class ShopInES implements Serializable{

    @JSONField(name = "shop_id")
    private Long shopId;

    @JSONField(name = "market_id")
    private Long marketId;

    @JSONField(name = "market")
    private String market;

    @JSONField(name = "floor_id")
    private Long floorId;

    @JSONField(name = "floor")
    private String floor;

    @JSONField(name = "user_id")
    private Long userId;

    @JSONField(name = "shop_name")
    private String shopName;

    @JSONField(name = "taobao_url")
    private String taobaoUrl;

    @JSONField(name = "tb_nick")
    private String tbNick;

    @JSONField(name = "shop_num")
    private String shopNum;

    @JSONField(name = "address")
    private String address;

    @JSONField(name = "telephone")
    private String telephone;

    @JSONField(name = "im_qq")
    private String imQq;

    @JSONField(name = "im_aliww")
    private String imAliww;

    @JSONField(name = "im_wx")
    private String imWx;

    @JSONField(name = "domain")
    private String domain;

    @JSONField(name = "create_date")
    private Date createDate;

    @JSONField(name = "shop_status")
    private Integer shopStatus;

    @JSONField(name = "data_packet_url")
    private String dataPacketUrl;

    @JSONField(name = "main_bus")
    private String mainBus;

    @JSONField(name = "system_recommon")
    private String systemRecommon;

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getMarketId() {
        return marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public Long getFloorId() {
        return floorId;
    }

    public void setFloorId(Long floorId) {
        this.floorId = floorId;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getTaobaoUrl() {
        return taobaoUrl;
    }

    public void setTaobaoUrl(String taobaoUrl) {
        this.taobaoUrl = taobaoUrl;
    }

    public String getTbNick() {
        return tbNick;
    }

    public void setTbNick(String tbNick) {
        this.tbNick = tbNick;
    }

    public String getShopNum() {
        return shopNum;
    }

    public void setShopNum(String shopNum) {
        this.shopNum = shopNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getImAliww() {
        return imAliww;
    }

    public void setImAliww(String imAliww) {
        this.imAliww = imAliww;
    }

    public String getImWx() {
        return imWx;
    }

    public void setImWx(String imWx) {
        this.imWx = imWx;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getShopStatus() {
        return shopStatus;
    }

    public void setShopStatus(Integer shopStatus) {
        this.shopStatus = shopStatus;
    }

    public String getDataPacketUrl() {
        return dataPacketUrl;
    }

    public void setDataPacketUrl(String dataPacketUrl) {
        this.dataPacketUrl = dataPacketUrl;
    }

    public String getMainBus() {
        return mainBus;
    }

    public void setMainBus(String mainBus) {
        this.mainBus = mainBus;
    }

    public String getSystemRecommon() {
        return systemRecommon;
    }

    public void setSystemRecommon(String systemRecommon) {
        this.systemRecommon = systemRecommon;
    }
}
