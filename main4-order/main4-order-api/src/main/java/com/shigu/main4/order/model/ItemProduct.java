package com.shigu.main4.order.model;

import com.shigu.main4.order.vo.ItemProductVO;
import com.shigu.main4.order.vo.ItemSkuVO;

import java.util.List;

/**
 * 商品类别的产品
 * Created by zhaohongbo on 17/6/1.
 */
public interface ItemProduct extends Product{

    ItemProductVO info();

    ItemSkuVO selSelectiveSku();
    /**
     * 查询SKU
     * @return
     */
    List<ItemSkuVO> selSkus();

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
     * 修改sku信息
     * @param color 颜色
     * @param size 尺码
     */
    Long modSelectiveSku(String color, String size);

    /**
     * 重量查询
     * @return
     */
    Long selWeight();

    /**
     *  获取 pid
     * @return 记录主键
     */
    Long getPid();

    /**
     * 获取sku_id
     */
    Long getSkuId();
}
