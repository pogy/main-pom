package com.shigu.main4.item.vo.news;

import com.shigu.main4.item.vo.SynItem;

import java.util.List;

public class NewPullSynItemVO extends SynItem {
    /**
     * 独立sku集合
     */
    private List<SingleSkuVO> singleSkus;

    /**
     * 获取 独立sku集合
     */
    public List<SingleSkuVO> getSingleSkus() {
        return this.singleSkus;
    }

    /**
     * 设置 独立sku集合
     */
    public void setSingleSkus(List<SingleSkuVO> singleSkus) {
        this.singleSkus = singleSkus;
    }
}
