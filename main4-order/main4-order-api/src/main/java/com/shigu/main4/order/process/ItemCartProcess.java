package com.shigu.main4.order.process;

import com.shigu.main4.order.exceptions.CartException;
import com.shigu.main4.order.vo.CartVO;
import com.shigu.main4.order.vo.ItemProductVO;

import java.util.List;

/**
 * 商品进货车服务
 * Created by bugzy on 2017/8/12 0012.
 */
public interface ItemCartProcess {

    List<CartVO> someOneCart(Long userId);

    /**
     * 根据用户id 子订单Id 查询子订单
     * @param userId
     * @param childCartIds
     * @return
     */
    List<CartVO> selByChildCartIds(Long userId,String childCartIds);

    int productNumbers(Long userId);

    void modProductNumber(Long user, Long cid, Integer number) throws CartException;

    /**
     * 删除进货车商品
     * @param userId 用户
     * @param cid 商品
     */
    void rmProduct(Long userId, Long cid);

    /**
     * 修改进货车商品属性
     * @param userId 用户
     * @param cid 商品
     * @param color 颜色
     * @param size 尺码
     */
    void modifyProductSku(Long userId, Long cid, String color, String size) throws CartException;

    /**
     * 向进货车添加商品
     * @param userId 用户
     * @param vo 商品信息
     * @param count 数量
     */
    void addProduct(Long userId, ItemProductVO vo, Integer count);

    /**
     * 清除某用户进货车中某商品的某数量
     * @param userId 用户
     * @param pid 产品id
     * @param skuId skuid
     * @param num 数量
     */
    void rmProductByNum(Long userId, Long pid, Long skuId, Integer num);
}
