package com.shigu.main4.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.shigu.opensearchsdk.anno.FetchApp;

import java.io.Serializable;

/**
 * 开放搜索商户数据
 * Created by bugzy on 2017/5/31 0031.
 */
@FetchApp("shop_search_ol")
public class OpenShopVo implements Serializable {

    @JSONField(name = "shop_id")
    private Long shopId;
    @JSONField(name = "market_id")
    private Long marketId;
    @JSONField(name = "floor_id")
    private Long floorId;
    @JSONField(name = "user_id")
    private Long userId;
    @JSONField(name = "shop_name")
    private String shopName;
    @JSONField(name = "web_site")
    private String webSite;
    @JSONField(name = "tb_nick")
    private String tbNick;
    @JSONField(name = "shop_num")
    private String shopNum;
    @JSONField(name = "shop_status")
    private Integer shopStatus;
    @JSONField(name = "market_name")
    private String marketName;

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

    public Long getFloorId() {
        return floorId;
    }

    public void setFloorId(Long floorId) {
        this.floorId = floorId;
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

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
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

    public Integer getShopStatus() {
        return shopStatus;
    }

    public void setShopStatus(Integer shopStatus) {
        this.shopStatus = shopStatus;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }
}
