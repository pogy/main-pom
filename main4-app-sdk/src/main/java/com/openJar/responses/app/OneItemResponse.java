package com.openJar.responses.app;

import com.openJar.beans.AppItemKv;
import com.openJar.responses.Response;

import java.util.Date;
import java.util.List;

/**
 * 类名：OneItemResponse
 * 类路径：com.openJar.responses.app.OneItemResponse
 * 创建者：王浩翔
 * 创建时间：2017-08-29 12:56
 * 项目：main-pom
 * 描述：app端单商品信息响应
 */
public class OneItemResponse extends Response {
    //标题 必须
    private String title;
    //商品ID 必须
    private String id;
    //商品5张图
    private List<String> imgSrcs;
    //货号
    private String goodsNo;
    //发布时间
    private Date createTime;
    //商品权益
    private List<String> goodsLicenses;
    //商品价格
    private String price;
    //店铺ID
    private Long storeId;
    //市场
    private String market;
    //档口号
    private String storeNum;
    //星星数
    private Integer starNum;
    //商品颜色
    private List<String> colors;
    //商品尺码
    private List<String> size;
    //商品参数
    private List<AppItemKv> itemKvs;
    //店铺头像
    private String shopHeadUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<String> getGoodsLicenses() {
        return goodsLicenses;
    }

    public void setGoodsLicenses(List<String> goodsLicenses) {
        this.goodsLicenses = goodsLicenses;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getStoreNum() {
        return storeNum;
    }

    public void setStoreNum(String storeNum) {
        this.storeNum = storeNum;
    }

    public Integer getStarNum() {
        return starNum;
    }

    public void setStarNum(Integer starNum) {
        this.starNum = starNum;
    }

    public List<String> getColors() {
        return colors;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    public List<String> getSize() {
        return size;
    }

    public void setSize(List<String> size) {
        this.size = size;
    }

    public List<AppItemKv> getItemKvs() {
        return itemKvs;
    }

    public void setItemKvs(List<AppItemKv> itemKvs) {
        this.itemKvs = itemKvs;
    }

    public String getShopHeadUrl() {
        return shopHeadUrl;
    }

    public void setShopHeadUrl(String shopHeadUrl) {
        this.shopHeadUrl = shopHeadUrl;
    }
}
