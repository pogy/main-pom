package com.shigu.sysman.goods.bo;


import com.shigu.component.common.page.PageParameter;

/**
 * 商品权重BO
 *
 * @author shigu_zjb
 * @date 2017/04/12 12:30
 *
 */
public class ShiguGoodsTinyBo extends PageParameter{

    /** 商品ID */
    private Long goodsId;

    /** 权重排序 */
    private Long gtSortOrder;

    /** 站点 */
    private String website;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getGtSortOrder() {
        return gtSortOrder;
    }

    public void setGtSortOrder(Long gtSortOrder) {
        this.gtSortOrder = gtSortOrder;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
