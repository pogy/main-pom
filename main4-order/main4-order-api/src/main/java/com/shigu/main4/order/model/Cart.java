package com.shigu.main4.order.model;

import com.shigu.main4.order.exceptions.ItemCartNumOutOfBoundsException;
import com.shigu.main4.order.vo.ProductVO;

/**
 * 购物车
 *
 * Created by zhaohongbo on 17/6/1.
 */
public interface Cart{
    /**
     * 添加产品
     * @param pro 带sku的产品
     */
    <T extends ProductVO> void addProduct(T pro,Integer num);

    /**
     * 删除购物车中的一个产品
     * @param cartId 在购物车中的一条产品ID
     */
    void rmProduct(Long cartId);

    /**
     * 按商品信息移除相应数量的商品
     * @param pid
     * @param skuId
     * @param num
     */
    void rmProductByNum(Long pid,Long skuId,Integer num) throws ItemCartNumOutOfBoundsException;

    /**
     * 修改购物车中产品数量
     * @param cartId
     * @param number
     * @return
     */
    Long modifyProductNumber(Long cartId,Integer number);

    /**
     * 修改购物车中产品的sku
     * @param cartId
     * @param skuId
     * @return
     */
    Long modifyProductSku(Long cartId,Long skuId);

    /**
     * 修改购物车中产品数量
     * @param pid pid
     * @param skuId skuId
     * @param number number
     */
}
