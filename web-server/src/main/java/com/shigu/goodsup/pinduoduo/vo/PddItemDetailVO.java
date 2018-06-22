package com.shigu.goodsup.pinduoduo.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by gtx on 2018/6/18.
 *
 * @author gtx
 * @since
 */
public class PddItemDetailVO implements Serializable{
    //标题	必须
    private String title;
    //商品ID	必须
    private String goodsId;
    //商品5张图
    private List<String> imgSrcs;
    //货号
    private String goodsNo;
    // 团购价  批发售价 + 团购利润
    private String price;
    //单买价 商品零售价格 + 零售利润
    private String liPrice;
    //利润
    private String profit;
    //商品颜色
    private List<ItemColorPropVO> colors;
    //商品尺码
    private List<String> size;
    //商品详情图
    private List<String> detailsImgs;
    //数量 固定999
    private Integer goodsNum;
    //长标题长度
    private int titleLength;
    //市场名
    private String marketName;
    //档口名
    private String shopNum;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public List<String> getImgSrcs() {
        return imgSrcs;
    }

    public void setImgSrcs(List<String> imgSrcs) {
        this.imgSrcs = imgSrcs;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLiPrice() {
        return liPrice;
    }

    public void setLiPrice(String liPrice) {
        this.liPrice = liPrice;
    }

    public String getProfit() {
        return profit;
    }

    public void setProfit(String profit) {
        this.profit = profit;
    }

    public List<ItemColorPropVO> getColors() {
        return colors;
    }

    public void setColors(List<ItemColorPropVO> colors) {
        this.colors = colors;
    }

    public List<String> getSize() {
        return size;
    }

    public void setSize(List<String> size) {
        this.size = size;
    }

    public List<String> getDetailsImgs() {
        return detailsImgs;
    }

    public void setDetailsImgs(List<String> detailsImgs) {
        this.detailsImgs = detailsImgs;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public int getTitleLength() {
        return titleLength;
    }

    public void setTitleLength(int titleLength) {
        this.titleLength = titleLength;
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
}
