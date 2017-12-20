package com.shigu.main4.item.vo;

import com.shigu.main4.common.tools.ShiguPager;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wxc on 2017/4/6.
 *
 * @author wxc
 * @version main_site4.0 4.0.0
 * @since main_site4.0 4.0.0
 */
public class ShiguAggsPager extends ShiguPager<SearchItem>  implements Serializable {
    private static final long serialVersionUID = 1755168562363930854L;

    private List<AggsCount> markets;

    private List<AggsCount> cats;
    private List<AggsCount> parentCats;

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
