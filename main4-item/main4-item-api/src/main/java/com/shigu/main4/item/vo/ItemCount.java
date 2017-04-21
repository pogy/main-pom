package com.shigu.main4.item.vo;

import java.io.Serializable;

/**
 * 店内商品统计
 * Created by zhaohongbo on 17/3/2.
 */
public class ItemCount implements Serializable{

    /**
     * 出售中的商品数
     */
    private Integer onsale;
    /**
     * 橱窗推荐数
     */
    private Integer showcase;
    /**
     * 仓库中的总数
     */
    private Integer instock;

    public Integer getOnsale() {
        return onsale;
    }

    public void setOnsale(Integer onsale) {
        this.onsale = onsale;
    }

    public Integer getShowcase() {
        return showcase;
    }

    public void setShowcase(Integer showcase) {
        this.showcase = showcase;
    }

    public Integer getInstock() {
        return instock;
    }

    public void setInstock(Integer instock) {
        this.instock = instock;
    }
}
