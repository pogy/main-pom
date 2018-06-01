package com.shigu.main4.item.bo.news;

import com.shigu.main4.item.vo.SynItem;

import java.util.List;

public class NewPushSynItemBO extends SynItem {
    /**
     * 独立sku集合
     */
    private List<SingleSkuBO> singleSkus;

    public List<SingleSkuBO> getSingleSkus() {
        return this.singleSkus;
    }

    public void setSingleSkus(List<SingleSkuBO> singleSkus) {
        this.singleSkus = singleSkus;
    }
}
