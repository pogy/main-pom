package com.shigu.main4.item.beans;

import com.opentae.core.mybatis.config.Column;

import java.io.Serializable;
import java.util.Date;

/**
 * 类名：GoodsInfoVO
 * 类路径：com.shigu.main4.item.beans.GoodsInfoVO
 * 创建者：王浩翔
 * 创建时间：2017-10-25 14:41
 * 项目：main-pom
 * 描述：goodsTiny基础信息
 */
public class GoodsInfoVO implements Serializable {
    /**
     * 商品ID
     */
    @Column("shigu_goods_tiny_{webSite}.goods_id")
    private Long itemId;
    /**
     * 标题
     */
    @Column("shigu_goods_tiny_{webSite}.title")
    private String title;
    /**
     * 首图
     */
    @Column("shigu_goods_tiny_{webSite}.pic_url")
    private String picUrl;
    /**
     * 货号
     */
    @Column("shigu_goods_tiny_{webSite}.goods_no")
    private String goodsNo;
    /**
     * 字符型的批发价
     * 以元为单位
     */
    @Column("shigu_goods_tiny_{webSite}.pi_price_string")
    private String piPrice;
    /**
     * 字符型的零售价
     * 以元为单位
     */
    @Column("shigu_goods_tiny_{webSite}.price_string")
    private String price;
    /**
     * 是否橱窗推荐,1是    0不是
     */
    @Column("shigu_goods_tiny_{webSite}.is_Showcase")
    private Integer isShowCase;
    /**
     * 创建时间
     */
    @Column("shigu_goods_tiny_{webSite}.created")
    private Date created;
    /**
     * 分站标识
     */
    @Column("shigu_goods_tiny_{webSite}.web_site")
    private String webSite;
    /**
     * 数据来源
     */
    @Column("shigu_goods_tiny_{webSite}.is_excel_imp")
    private Integer isExcelImp;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getPiPrice() {
        return piPrice;
    }

    public void setPiPrice(String piPrice) {
        this.piPrice = piPrice;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getIsShowCase() {
        return isShowCase;
    }

    public void setIsShowCase(Integer isShowCase) {
        this.isShowCase = isShowCase;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public Integer getIsExcelImp() {
        return isExcelImp;
    }

    public void setIsExcelImp(Integer isExcelImp) {
        this.isExcelImp = isExcelImp;
    }
}
