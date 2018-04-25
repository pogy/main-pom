package com.opentae.data.daifa.beans;

import com.opentae.core.mybatis.config.Column;

import javax.persistence.Transient;
import java.io.Serializable;

/**
 * Created by pc on 2017-08-31.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
public class AfterSaleSubData implements Serializable {
    @Transient
    private static final long serialVersionUID = 2305293469566510639L;

    @Column("daifa_order.df_order_id")
    private Long childOrderId;//子单id
    @Column("daifa_order.pic_path")
    private String imgSrc;//商品图片
    @Column("daifa_order.title")
    private String title;//商品标题
    @Column("daifa_order.prop_str")
    private String goodsProperty;//商品属性 颜色 尺码
    @Column("daifa_order.goods_code")
    private String goodsNo;//商品货号
    @Column("daifa_order.single_price")
    private String piPrice;//商品批发价
    @Column("daifa_order.single_pi_price")
    private String payPrice;//商品实际支付价
    @Column("daifa_order.goods_num")
    private Integer num;//商品数量
    @Column("daifa_order.single_services_fee")
    private String childServersFee;//子单服务费用
    @Column("daifa_order.store_goods_code")
    private String storeGoodsCode;
    @Column("daifa_order.take_goods_status")
    private Integer takeGoodsState;


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

    public String getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(String payPrice) {
        this.payPrice = payPrice;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getChildServersFee() {
        return childServersFee;
    }

    public void setChildServersFee(String childServersFee) {
        this.childServersFee = childServersFee;
    }

    public String getStoreGoodsCode() {
        return storeGoodsCode;
    }

    public void setStoreGoodsCode(String storeGoodsCode) {
        this.storeGoodsCode = storeGoodsCode;
    }

    public Integer getTakeGoodsState() {
        return this.takeGoodsState;
    }

    public void setTakeGoodsState(Integer takeGoodsState) {
        this.takeGoodsState = takeGoodsState;
    }
}
