package com.shigu.search.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 搜索中的栏目
 * Created by zhaohongbo on 17/4/7.
 */
public class CateNavsInSearch implements Serializable{
    /**
     * 类目
     */
    private List<CateNav> cates;
    /**
     * 市场
     */
    private List<CateNav> markets;

    public List<CateNav> getCates() {
        return cates;
    }

    public void setCates(List<CateNav> cates) {
        this.cates = cates;
    }

    public List<CateNav> getMarkets() {
        return markets;
    }

    public void setMarkets(List<CateNav> markets) {
        this.markets = markets;
    }
}
