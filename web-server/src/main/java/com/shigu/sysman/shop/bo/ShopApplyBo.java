package com.shigu.sysman.shop.bo;

import com.shigu.component.common.page.PageParameter;


/**
 * 店铺入驻审核BO
 *
 * @author shigu_zjb
 * @date 2017/03/10 13:34
 *
 */
public class ShopApplyBo extends PageParameter{

    private Long applyId;

    private String shopNum;

    private Integer applyStatus;

    private Integer canExamine;

    private String website;

    public Long getApplyId() {
        return applyId;
    }

    public void setApplyId(Long applyId) {
        this.applyId = applyId;
    }

    public String getShopNum() {
        return shopNum;
    }

    public void setShopNum(String shopNum) {
        this.shopNum = shopNum;
    }

    public Integer getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(Integer applyStatus) {
        this.applyStatus = applyStatus;
    }

    public Integer getCanExamine() {
        return canExamine;
    }

    public void setCanExamine(Integer canExamine) {
        this.canExamine = canExamine;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
