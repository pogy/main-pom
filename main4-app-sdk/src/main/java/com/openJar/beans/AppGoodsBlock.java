package com.openJar.beans;

import com.openJar.utils.OpenBean;

/**
 * 类名：AppGoodsBlock
 * 类路径：com.openJar.beans.AppGoodsBlock
 * 创建者：王浩翔
 * 创建时间：2017-08-29 13:10
 * 项目：main-pom
 * 描述：app端商品块信息
 */
public class AppGoodsBlock extends OpenBean {
    //todo:String/Long
    //商品ID
    private String id;
    //标题
    private String title;
    //高亮型标题
    private String highLightTitle;
    //图片链接
    private String imgsrc;
    //批发价
    private String piprice;
    //市场档口，空格隔开
    private String fullStoreName;
    //旺旺昵称
    private String aliww;
    //todo:String/Long
    //店铺ID
    private String storeid;
    //货号
    private String goodsNo;
    //高亮型货号，一般情况下此字段为null，如果有值说明货号匹配上了
    private String highLightGoodsNo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHighLightTitle() {
        return highLightTitle;
    }

    public void setHighLightTitle(String highLightTitle) {
        this.highLightTitle = highLightTitle;
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

    public String getFullStoreName() {
        return fullStoreName;
    }

    public void setFullStoreName(String fullStoreName) {
        this.fullStoreName = fullStoreName;
    }

    public String getAliww() {
        return aliww;
    }

    public void setAliww(String aliww) {
        this.aliww = aliww;
    }

    public String getStoreid() {
        return storeid;
    }

    public void setStoreid(String storeid) {
        this.storeid = storeid;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getHighLightGoodsNo() {
        return highLightGoodsNo;
    }

    public void setHighLightGoodsNo(String highLightGoodsNo) {
        this.highLightGoodsNo = highLightGoodsNo;
    }
}
