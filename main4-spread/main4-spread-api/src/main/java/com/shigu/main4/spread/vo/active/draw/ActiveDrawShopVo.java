package com.shigu.main4.spread.vo.active.draw;


import java.io.Serializable;

/**
 *
 * 活动抽奖店铺信息VO
 *
 * @author shigu_zjb
 * @date 2017/05/12 20:35
 *
 *
 */
public class ActiveDrawShopVo implements Serializable {

    /** 主键ID */
    private Long id;

    /** 期次ID */
    private Long pemId;

    private Long pitId;

    private Integer num;

    /** 店铺ID */
    private Long shopId;

    /** 市场名称 */
    private String marketName;

    /** 档口号 */
    private String shopNum;

    /** 店铺图片 */
    private String imgSrc;

    private String uText;

    private String dText;

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

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getuText() {
        return uText;
    }

    public void setuText(String uText) {
        this.uText = uText;
    }

    public String getdText() {
        return dText;
    }

    public void setdText(String dText) {
        this.dText = dText;
    }

    public Long getPitId() {
        return pitId;
    }

    public void setPitId(Long pitId) {
        this.pitId = pitId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
