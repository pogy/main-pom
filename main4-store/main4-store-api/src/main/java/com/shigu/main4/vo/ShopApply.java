package com.shigu.main4.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 店铺申请信息
 * Created by zhaohongbo on 17/3/14.
 */
public class ShopApply implements Serializable {
    /**
     * 入驻ID
     */
    private Long ruzhuId;
    /**
     * 档口号
     */
    private String shopNum;
    /**
     * 市场
     */
    private String market;
    /**
     * 分站标识
     */
    private String webSite;
    /**
     * 申请时间
     */
    private Date applyTime;
    /**
     * 0表示未处理，1表示审核通过，2表示拒绝
     */
    private Integer status;

    public Long getRuzhuId() {
        return ruzhuId;
    }

    public void setRuzhuId(Long ruzhuId) {
        this.ruzhuId = ruzhuId;
    }

    public String getShopNum() {
        return shopNum;
    }

    public void setShopNum(String shopNum) {
        this.shopNum = shopNum;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
