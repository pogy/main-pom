package com.shigu.daifa.vo;

import javax.persistence.Transient;
import java.io.Serializable;

/**
 * Created by pc on 2017-08-15.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
public class OrderAllocateVO implements Serializable{
    @Transient
    private static final long serialVersionUID = -7104490592684464641L;
    private Long childOrderId;//子弹id
    private String imgSrc;//图片
    private String title;//标题
    private String goodsProperty;//	商品属性（颜色尺码）
    private String goodsNo;//	商品货号
    private String piPrice;//	商品批发价
    private Integer num;//商品数量
    private Integer dffs;//代发方式，1普通代发。实在想不出字段名了

    public Long getChildOrderId() {
        return childOrderId;
    }

    public void setChildOrderId(Long childOrderId) {
        this.childOrderId = childOrderId;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGoodsProperty() {
        return goodsProperty;
    }

    public void setGoodsProperty(String goodsProperty) {
        this.goodsProperty = goodsProperty;
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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getDffs() {
        return dffs;
    }

    public void setDffs(Integer dffs) {
        this.dffs = dffs;
    }
}
