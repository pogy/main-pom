package com.shigu.main4.vo.fitment;

import com.shigu.main4.enums.FitmentModuleType;

import java.util.List;

/**
 * 商品搜索模块
 * Created by Administrator on 2017/4/18 0018.
 */
public class ItemSearchModule extends TitleShowModule {
    public ItemSearchModule() {
        this.setTitle("本店搜索");
    }

    /**
     * 预置搜索词
     */
    private String keyword;
    /**
     * 推荐搜索词
     */
    private List<String> keywords;
    /**
     * 是否显示价格筛选
     */
    private Integer priceScreen = 1;

    @Override
    public Integer getModuleType() {
        return FitmentModuleType.Search.value;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public Integer getPriceScreen() {
        return priceScreen;
    }

    public void setPriceScreen(Integer priceScreen) {
        this.priceScreen = priceScreen;
    }
}
