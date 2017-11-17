package com.shigu.seller.vo;

import java.io.Serializable;

/**
 * @类编号
 * @类名称：PackageVO
 * @文件路径：com.shigu.main4.ucenter.vo.PackageVO
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/11/3 20:24
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class PackageVO implements Serializable{

    private Long goodsId;//数据包商品id
    private String title;//数据包商品标题
    private String piPrice;//数据包商品批发价
    private String shopCode;//数据包商品编码
    private String catName;//类目名

    public Long getGoodsId () {
        return goodsId;
    }

    public void setGoodsId (Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public String getPiPrice () {
        return piPrice;
    }

    public void setPiPrice (String piPrice) {
        this.piPrice = piPrice;
    }

    public String getShopCode () {
        return shopCode;
    }

    public void setShopCode (String shopCode) {
        this.shopCode = shopCode;
    }

    public String getCatName () {
        return catName;
    }

    public void setCatName (String catName) {
        this.catName = catName;
    }
}
