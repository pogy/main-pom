package com.shigu.search.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 店铺列表
 * Created by zhaohongbo on 17/4/5.
 */
public class StoreInSearch implements Serializable{
    /**
     * 档口id
     */
    private String id;
    /**
     * 档口图标
     */
    private String imgsrc;
    /**
     * 档口名称
     */
    private String name;
    /**
     * 高亮name
     */
    private String highName;
    /**
     * 档口所属市场名
     */
    private String marketName;
    /**
     * 高亮市场
     */
    private String highMarketName;
    /**
     * 档口信用分
     */
    private String xy;
    /**
     * 档口阿里旺旺
     */
    private String aliww;
    /**
     * 档口联系qq
     */
    private String imqq;
    /**
     * 档口主营类目
     */
    private String mainCate;
    /**
     * 档口市场全称
     */
    private String fullMarketText;
    /**
     * 档口联系电话
     */
    private String tel;
    /**
     * 档口商品数
     */
    private Integer goodsCount;
    /**
     * 档口里的商品
     */
    private List<GoodsInStoreSearch> goodslist;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImgsrc() {
        if (imgsrc == null) {
            return "http://gw.alicdn.com/tps/i3/TB1yeWeIFXXXXX5XFXXuAZJYXXX-210-210.png_80x80.jpg";
        }
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getXy() {
        return xy;
    }

    public void setXy(String xy) {
        this.xy = xy;
    }

    public String getAliww() {
        return aliww;
    }

    public void setAliww(String aliww) {
        this.aliww = aliww;
    }

    public String getImqq() {
        return imqq;
    }

    public void setImqq(String imqq) {
        this.imqq = imqq;
    }

    public String getMainCate() {
        return mainCate;
    }

    public void setMainCate(String mainCate) {
        this.mainCate = mainCate;
    }

    public String getFullMarketText() {
        return fullMarketText;
    }

    public void setFullMarketText(String fullMarketText) {
        this.fullMarketText = fullMarketText;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public List<GoodsInStoreSearch> getGoodslist() {
        return goodslist;
    }

    public void setGoodslist(List<GoodsInStoreSearch> goodslist) {
        this.goodslist = goodslist;
    }

    public String getHighMarketName() {
        return highMarketName;
    }

    public void setHighMarketName(String highMarketName) {
        this.highMarketName = highMarketName;
    }

    public String getHighName() {
        return highName;
    }

    public void setHighName(String highName) {
        this.highName = highName;
    }
}
