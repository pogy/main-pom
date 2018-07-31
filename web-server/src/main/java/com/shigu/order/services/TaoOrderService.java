package com.shigu.order.services;

import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.order.bo.TbOrderBO;
import com.shigu.main4.order.exceptions.NotFindRelationGoodsException;
import com.shigu.main4.order.exceptions.NotFindSessionException;
import com.shigu.main4.order.servicevo.TbOrderVO;
import com.shigu.main4.order.zfenums.TbOrderStatusEnum;
import com.shigu.order.vo.TinyVO;

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
     * @功能： 获取淘宝session
     * @param: userId:星座用户ID
     * @return:
     * @exception: 未查询到sessionKey
     * ====================================================================================
     *
     */
    String myTbSessionKey(Long userId) throws NotFindSessionException;

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
    ShiguPager<TbOrderVO> myTbOrders(TbOrderBO bo, String sessionKey);

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
    TbOrderVO myTbOrder(Long tid, TbOrderStatusEnum status, String sessionKey);

    /**
     * ====================================================================================
     * @方法名：找回源商品
     * @功能： 关联,如果已关联,返回关联的货号,如果未关联,根据numiid查询商品进行管理,成功则返回货号
     * @param:numiid商品ID
     * @return:商家编码 货号
     * @exception:
     * ====================================================================================
     *
     */
    TinyVO selSourceGoodsByNumIid(Long numiid) throws NotFindRelationGoodsException;

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
    void glGoodsJson(Long numiid, Long goodsId,Long userId) throws NotFindRelationGoodsException;

}
