package com.shigu.buyer.vo;


import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * Created by wxc on 2017/1/13.
 * 一键上传记录值
 *
 * @author wxc
 * @version main-site3.2 3.0.0
 * @since main-site3.2 3.0.0
 */
public class OnekeyRecoreVO implements java.io.Serializable {

    // 商品id
    private Long goodsId;
    // 一键上传es主键
    private String onekeyId;
    // 商品标题
    private String title;
    // 商品图片
    private String imgsrc;
    // 商品批发价
    private String piprice;
    // 商品所属市场
    private String marketName;
    // 商品所属档口
    private String shopNum;
    // 上传时间
    private String upTime;
    // 淘宝在售状态 1在售 2下架
    private Integer taobaoSaleState;
    // 档口在售状态 1在售 2下架
    private Integer shopSaleState;
    // 货号
    private String goodsNo;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getOnekeyId() {
        return onekeyId;
    }

    public void setOnekeyId(String onekeyId) {
        this.onekeyId = onekeyId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public String getPiprice() {
        return piprice;
    }

    public void setPiprice(String piprice) {
        this.piprice = piprice;
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

    public String getUpTime() {
        return upTime;
    }

    public void setUpTime(String upTime) {
        this.upTime = upTime;
    }

    public Integer getTaobaoSaleState() {
        return taobaoSaleState;
    }

    public void setTaobaoSaleState(Integer taobaoSaleState) {
        this.taobaoSaleState = taobaoSaleState;
    }

    public Integer getShopSaleState() {
        return shopSaleState;
    }

    public void setShopSaleState(Integer shopSaleState) {
        this.shopSaleState = shopSaleState;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }
}