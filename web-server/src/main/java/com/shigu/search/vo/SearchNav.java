package com.shigu.search.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 搜索顶部导航
 * Created by zhaohongbo on 17/4/6.
 */
public class SearchNav implements Serializable{

    private Integer goodsCount;

    private List<SearchKey> cates;

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public List<SearchKey> getCates() {
        return cates;
    }

    public void setCates(List<SearchKey> cates) {
        this.cates = cates;
    }
}
