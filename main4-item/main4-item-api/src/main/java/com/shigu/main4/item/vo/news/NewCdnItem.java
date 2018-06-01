package com.shigu.main4.item.vo.news;

import com.shigu.main4.item.enums.ItemFrom;
import com.shigu.main4.item.vo.CdnItem;
import com.shigu.main4.item.vo.NormalProp;
import com.shigu.main4.item.vo.SaleProp;

import java.io.Serializable;
import java.util.List;

/**
 * 给显示商品详情页面用的对象
 * Created by zhaohongbo on 17/2/16.
 */
public class NewCdnItem extends CdnItem{
    /**
     * 独立sku
     */
    private List<SingleSkuVO> singleSkus;

    /**
     * 获取 独立sku
     */
    public List<SingleSkuVO> getSingleSkus() {
        return this.singleSkus;
    }

    /**
     * 设置 独立sku
     */
    public void setSingleSkus(List<SingleSkuVO> singleSkus) {
        this.singleSkus = singleSkus;
    }
}
