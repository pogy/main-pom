package com.shigu.main4.vo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 开放搜索商户数据
 * Created by bugzy on 2017/5/31 0031.
 */
public class OpenShopVo {

    private Long shopId;
    private Long marketId;
    private Long floorId;
    private Long userId;
    private String shopName;
    private String webSite;
    private String tbNick;
    private String shopNum;
    private Integer shopStatus;
    private String marketName;

    @JSONField(name = "shop_id")
    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
    @JSONField(name = "market_id")
    public Long getMarketId() {
        return marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }
    @JSONField(name = "floor_id")
    public Long getFloorId() {
        return floorId;
    }

    public void setFloorId(Long floorId) {
        this.floorId = floorId;
    }
    @JSONField(name = "user_id")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    @JSONField(name = "shop_name")
    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
    @JSONField(name = "web_site")
    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }
    @JSONField(name = "tb_nick")
    public String getTbNick() {
        return tbNick;
    }

    public void setTbNick(String tbNick) {
        this.tbNick = tbNick;
    }
    @JSONField(name = "shop_num")
    public String getShopNum() {
        return shopNum;
    }

    public void setShopNum(String shopNum) {
        this.shopNum = shopNum;
    }
    @JSONField(name = "shop_status")
    public Integer getShopStatus() {
        return shopStatus;
    }

    public void setShopStatus(Integer shopStatus) {
        this.shopStatus = shopStatus;
    }
    @JSONField(name = "market_name")
    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }
}
