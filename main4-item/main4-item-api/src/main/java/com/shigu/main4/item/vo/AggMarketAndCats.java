package com.shigu.main4.item.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wxc on 2017/4/7.
 *
 * @author wxc
 * @version main_site4.0 4.0.0
 * @since main_site4.0 4.0.0
 */
public class AggMarketAndCats implements Serializable{

    private List<AggsCount> cats;

    private List<AggsCount> parentCats;

    private List<AggsCount> markets;

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

    public List<AggsCount> getMarkets() {
        return markets;
    }

    public void setMarkets(List<AggsCount> markets) {
        this.markets = markets;
    }
}
