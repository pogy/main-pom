package com.shigu.main4.order.model;

import com.shigu.main4.order.exceptions.CartException;
import com.shigu.main4.order.vo.ProductVO;

import java.util.List;

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
    void rmProductByNum(Long pid,Long skuId,Integer num);

    /**
     * 修改购物车中产品数量
     * @param cartId
     * @param number
     * @return
     */
    Long modifyProductNumber(Long cartId,Integer number) throws CartException;

    ItemProduct getProduct(Long cartId) throws CartException;
    /**
     * 修改购物车中产品的sku
     * @param cartId
     */
    Long modifyProductSku(Long cartId, String color, String size) throws CartException;

    /**
     * 某用户购物车商品数量
     * @return
     */
    int productNumbers();

    /**
     * 获取购物车内所有产品
     * @param <T> 具体产品类型
     * @return 产品列表
     */
    <T extends ProductVO> List<T> listProduct();

    /**
     * 根据子订单id集合获取购物车内部分产品
     * @param <T> 具体产品类型
     * @return 产品列表
     */
    <T extends ProductVO> List<T> listSomeProduct(String childCartIds);
}
