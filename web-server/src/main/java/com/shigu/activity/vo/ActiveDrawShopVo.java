package com.shigu.activity.vo;


/**
 *
 * 活动抽奖店铺信息VO
 *
 * @author shigu_zjb
 * @date 2017/05/12 20:35
 *
 *
 */
public class ActiveDrawShopVo {

    /** 主键ID */
    private Long id;

    /** 期次ID */
    private Long pemId;

    /** 店铺ID */
    private Long shopId;

    /** 市场名称 */
    private String marketName;

    /** 档口号 */
    private String shopNum;

    /** 店铺图片 */
    private String picUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPemId() {
        return pemId;
    }

    public void setPemId(Long pemId) {
        this.pemId = pemId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getShopNum() {
        return shopNum;
    }

    public void setShopNum(String shopNum) {
        this.shopNum = shopNum;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
