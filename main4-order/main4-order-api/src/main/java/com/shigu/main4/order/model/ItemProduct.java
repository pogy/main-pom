package com.shigu.main4.order.model;

import com.shigu.main4.order.vo.ItemSkuVO;

import java.util.List;

/**
 * 商品类别的产品
 * Created by zhaohongbo on 17/6/1.
 */
public interface ItemProduct extends Product{

    /**
     * 查询SKU
     * @return
     */
    List<ItemSkuVO> selSkus();

    /**
     * 添加SKU
     * @param sku
     * @return
     */
    Long addSku(ItemSkuVO sku);

    /**
     * 修改重量
     * @param meter
     */
    void modifyWeight(Long meter);

    /**
     * 修改价格
     * @param price
     */
    void modifyPrice(Long price);

    /**
     * 重量查询
     * @return
     */
    Long selWeight();
}
