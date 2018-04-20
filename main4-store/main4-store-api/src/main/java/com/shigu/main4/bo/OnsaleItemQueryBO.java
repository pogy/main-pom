package com.shigu.main4.bo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class OnsaleItemQueryBO implements Serializable {

    /** 商品标题 */
    private String keyword;

    /** 排序规则 */
    private String orderBy;

    /** 商品id表 */
    private List<Long> goodsIds;

    /** 淘宝类目 */
    private Long cid;

    /** 店内类目 */
    private String scid;

    /** 价格起始 */
    private Double priceFrom;

    /** 价格结束 */
    private Double priceTo;

    /** 时间开始 */
    private Date dateFrom;

    /** 时间结束 */
    private Date dateTo;

    /** shop id */
    private Long shopId;

    /** 父类风格id */
    private Long parentStyleId;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public List<Long> getGoodsIds() {
        return goodsIds;
    }

    public void setGoodsIds(List<Long> goodsIds) {
        this.goodsIds = goodsIds;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getScid() {
        return scid;
    }

    public void setScid(String scid) {
        this.scid = scid;
    }

    public Double getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(Double priceFrom) {
        this.priceFrom = priceFrom;
    }

    public Double getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(Double priceTo) {
        this.priceTo = priceTo;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getParentStyleId() {
        return parentStyleId;
    }

    public void setParentStyleId(Long parentStyleId) {
        this.parentStyleId = parentStyleId;
    }
}
