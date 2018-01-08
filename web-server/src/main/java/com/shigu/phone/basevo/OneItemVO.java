package com.shigu.phone.basevo;

import com.openJar.beans.app.AppItemKv;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.List;

/**
 * Created By pc on 2017-10-17/17:39
 */
public class OneItemVO implements Serializable {

    //标题	必须
    private String title;
    //商品ID	必须
    private String goodsId;
    //商品5张图
    private List<String> imgSrcs;
    //货号
    private String goodsNo;
    //发布时间&nbsp;yyyy-MM-dd
    private String createTime;
    //商品权益
    private List<String> goodsLicenses;
    // 零售价
    private String price;
    //商品价格
    private String liPrice;
    //利润
    private String profit;
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
    //商品收藏Id  为空未收藏
    private Long collectId;
    //商品详情
    private String details;

    public String getTitle() {
        if(StringUtils.isNotBlank(title)){
            title= KeyWordsUtil.duleKeyWords(title);
        }
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
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

    public Long getCollectId() {
        return collectId;
    }

    public void setCollectId( Long collectId ) {
        this.collectId = collectId;
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

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
