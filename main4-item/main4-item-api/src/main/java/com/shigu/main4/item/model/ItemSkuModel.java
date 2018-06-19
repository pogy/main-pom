package com.shigu.main4.item.model;

import com.shigu.main4.item.bo.news.SingleSkuBO;
import com.shigu.main4.item.vo.CatColorSizeVO;
import com.shigu.main4.item.vo.news.SingleSkuVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ItemSkuModel {

    /**
     * 获取当前商品的sku集合,不包含无效的(数量为0的并不是无效的)
     * @return
     */
    List<SingleSkuVO> pull();
    /**
     * 获取当前商品的sku集合
     * @return
     */
    List<SingleSkuVO> pullAll();
    /**
     * 修改sku
     * 如果不存在,则新增
     * 如果库中存在,则修改
     * 如果参数中不存在,库中存在,则改为无效
     * @param skus
     */
    void push(List<SingleSkuBO> skus);

    /**
     * 修改库存,如果为0,则将sku改为无效
     * @param skuId
     * @param stockNum
     */
    void updateStockNum(Long skuId,Integer stockNum);
}
