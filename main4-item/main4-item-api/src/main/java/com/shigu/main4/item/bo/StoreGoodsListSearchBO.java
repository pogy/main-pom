package com.shigu.main4.item.bo;

import java.io.Serializable;

/**
 * 类名：StoreGoodsListSearchBO
 * 类路径：com.shigu.main4.item.bo.StoreGoodsListSearchBO
 * 创建者：王浩翔
 * 创建时间：2017-10-25 15:31
 * 项目：main-pom
 * 描述：供应商后台出售中的商品搜索BO
 */
public class StoreGoodsListSearchBO implements Serializable {
    //商品标题关键字
    private String keyword;
    //货号
    private String goodsNo;
    //1无最低零售价 2无大图 3无材料成分 null全部商品
    private Integer state;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
