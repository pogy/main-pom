package com.shigu.main4.order.services;


import com.shigu.main4.order.bo.TbOrderBO;
import com.shigu.main4.order.vo.GoodsVO;
import com.shigu.main4.order.vo.TbOrderVO;

import java.util.List;

/**
 * @类编号
 * @类名称：TaoOrderService
 * @文件路径：com.shigu.main4.order.services.TaoOrderService
 * @内容摘要：淘宝订单的服务
 * @编码作者：gzy
 * @创建日期：2017/7/14 14:57
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public interface TaoOrderService {
    /**
     * ====================================================================================
     * @方法名：
     * @功能：拉取淘宝订单列表
     * @param:bo查询条件
     * @return:
     * @exception:
     * ====================================================================================
     *
     */
    List<TbOrderVO> myTbOrders(TbOrderBO bo);

    /**
     * ====================================================================================
     * @方法名：
     * @功能：拉取单个淘宝订单
     * @param:tid淘宝订单id
     * @return:
     * @exception:
     * ====================================================================================
     *
     */
    TbOrderVO myTbOrder(Long tid);



    /**
     * ====================================================================================
     * @方法名：glGoodsJson
     * @功能：关联
     * @param:numiid商品ID
     * @return:商家编码 货号
     * @exception:
     * ====================================================================================
     *
     */
    String glGoodsJson(Long numiid);



    /**
     * ====================================================================================
     * @方法名：glGoodsJson
     * @功能：重新关联
     * @param:numiid商品ID
     * @return:商家编码  货号
     * @exception:
     * ====================================================================================
     *
     */
    String reglGoodsJson(Long numiid);

    /**
     * ====================================================================================
     * @方法名：selectglGoodsJson
     * @功能： 关联搜索
     * @param: condition搜索的条件
     * @return: 返回搜索出来的商品
     * @exception: 
     * ====================================================================================
     * 
     */
    List<GoodsVO> selectglGoodsJson(String condition);

    /**
     * ====================================================================================
     * @方法名：
     * @功能： 搜索后的关联
     * @param: numiid淘宝订单的商品ID,goodsId是搜索出来的ID
     * @return: 返回商品对应的json
     * @exception: 
     * ====================================================================================
     * 
     */
    GoodsVO glGoodsJson(Long numiid,Long goodsId);

}
