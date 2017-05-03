package com.shigu.sysman.shop.bo;


import com.shigu.component.common.page.PageParameter;
import org.apache.ibatis.annotations.Param;

/**
 * 店铺bo
 *
 * @author shigu_zjb
 * @date 2017/03/09 16:01
 *
 */
public class ShopBo extends PageParameter {

    /** 站点 */
    private String website;

    /** 用户名 */
    private String userName;

    /** 用户ID */
    private Long userId;

    /** 市场ID */
    private Long marketId;

    /** 楼层ID */
    private Long floorId;

    /** 店铺ID */
    private Long shopId;

    private String taobaoUrl;

    private String shopName;

    private String shopNum;

    private String tbNick;

    private boolean canAddShop;

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getTaobaoUrl() {
        return taobaoUrl;
    }

    public void setTaobaoUrl(String taobaoUrl) {
        this.taobaoUrl = taobaoUrl;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopNum() {
        return shopNum;
    }

    public void setShopNum(String shopNum) {
        this.shopNum = shopNum;
    }

    public String getTbNick() {
        return tbNick;
    }

    public void setTbNick(String tbNick) {
        this.tbNick = tbNick;
    }

    public boolean isCanAddShop() {
        return canAddShop;
    }

    public void setCanAddShop(boolean canAddShop) {
        this.canAddShop = canAddShop;
    }
}
