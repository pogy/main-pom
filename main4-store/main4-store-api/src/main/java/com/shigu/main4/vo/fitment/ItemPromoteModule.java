package com.shigu.main4.vo.fitment;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;
import java.util.List;

/**
 * 宝贝推荐设置对象
 * Created by Administrator on 2017/4/18 0018.
 */
public class ItemPromoteModule extends TitleShowModule {

    /**
     * 推荐方式 0/1  自动/手动
     */
    private Integer promoteType = 1;
    private Integer sort = 1;
    private Integer category;
    private String keyword;
    private Double lowerLimitPrice;
    private Double upperLimitPrice;
    private Integer showPage = 0;
    private Integer itemNum = 16;
    private List<Long> promoteItems = new ArrayList<>();
    /**
     * 0/1 不显示/显示
     */
    private Integer showTitle=1;
    private Integer showGoodsNo=0;
    private Integer showPrice=1;

    //电脑端显示设置
    /**
     * 展示方式:一行几个商品
     */
    private Integer radio=4;

    /**
     * 显示筛选
     */
    private Integer filter = 1;

    public ItemPromoteModule() {
        setTitle("推荐宝贝");
    }

    public Integer getPromoteType() {
        return promoteType;
    }

    public void setPromoteType(Integer promoteType) {
        this.promoteType = promoteType;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Double getLowerLimitPrice() {
        return lowerLimitPrice;
    }

    public void setLowerLimitPrice(Double lowerLimitPrice) {
        this.lowerLimitPrice = lowerLimitPrice;
    }

    public Double getUpperLimitPrice() {
        return upperLimitPrice;
    }

    public void setUpperLimitPrice(Double upperLimitPrice) {
        this.upperLimitPrice = upperLimitPrice;
    }

    public Integer getShowPage() {
        return showPage;
    }

    public void setShowPage(Integer showPage) {
        this.showPage = showPage;
    }

    public Integer getItemNum() {
        return itemNum;
    }

    public void setItemNum(Integer itemNum) {
        this.itemNum = itemNum;
    }

    @JSONField(serialize = false)
    public List<Long> getPromoteItems() {
        return promoteItems;
    }

    public void setPromoteItems(List<Long> promoteItems) {
        this.promoteItems = promoteItems;
    }

    public Integer getShowTitle() {
        return showTitle;
    }

    public void setShowTitle(Integer showTitle) {
        this.showTitle = showTitle;
    }

    public Integer getShowGoodsNo() {
        return showGoodsNo;
    }

    public void setShowGoodsNo(Integer showGoodsNo) {
        this.showGoodsNo = showGoodsNo;
    }

    public Integer getShowPrice() {
        return showPrice;
    }

    public void setShowPrice(Integer showPrice) {
        this.showPrice = showPrice;
    }

    public Integer getRadio() {
        return radio;
    }

    public void setRadio(Integer radio) {
        this.radio = radio;
    }

    public Integer getFilter() {
        return filter;
    }

    public void setFilter(Integer filter) {
        this.filter = filter;
    }
}
