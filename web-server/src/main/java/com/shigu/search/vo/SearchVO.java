package com.shigu.search.vo;

import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.item.vo.AggsCount;

import java.util.List;

/**
 * 搜索结果数据
 * Created by zhaohongbo on 17/4/7.
 */
public class SearchVO {

    private ShiguPager<GoodsInSearch> searchData;

    private List<AggsCount> markets;

    private List<AggsCount> cats;
    private List<AggsCount> parentCats;

    public ShiguPager<GoodsInSearch> getSearchData() {
        return searchData;
    }

    public void setSearchData(ShiguPager<GoodsInSearch> searchData) {
        this.searchData = searchData;
    }

    public List<AggsCount> getMarkets() {
        return markets;
    }

    public void setMarkets(List<AggsCount> markets) {
        this.markets = markets;
    }

    public List<AggsCount> getCats() {
        return cats;
    }

    public void setCats(List<AggsCount> cats) {
        this.cats = cats;
    }

    public List<AggsCount> getParentCats() {
        return parentCats;
    }

    public void setParentCats(List<AggsCount> parentCats) {
        this.parentCats = parentCats;
    }
}
