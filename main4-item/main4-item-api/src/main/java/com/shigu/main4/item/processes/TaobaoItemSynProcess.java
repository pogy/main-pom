package com.shigu.main4.item.processes;

import com.shigu.main4.item.exceptions.TbItemSynException;
import com.shigu.main4.item.exceptions.TbTmcException;
import com.shigu.main4.item.vo.TmcUserVO;

import java.util.List;
import java.util.Map;

/**
 * 淘宝商品同步业务
 */
public interface TaobaoItemSynProcess {



    /**
     * 同步店内一件商品
     * @param shopId
     * @param numIid
     * @param nick
     */
    void synOneItem(Long shopId, Long numIid, String nick) throws TbItemSynException;

    /**
     * 同步一个店的商品
     * @param shopId
     * @param nick
     */
    void synOneShop(Long shopId, String nick) throws TbItemSynException;

    /**
     * 异步同步一个店的商品
     */
    void synOneShopAsyn(Long shopId, String nick);

    /**
     * 修复店内类目
     * @param shopId
     * @param nick
     */
    void repairStorecat(Long shopId, String nick) throws TbItemSynException;

    /**
     * 修复商品类目
     * @param shopId
     * @param nick
     */
    void repairGoodscat(Long shopId, String nick) throws TbItemSynException;

    /**
     * 开通用户推送
     * @param nick
     */
    void addToTmc(String nick) throws TbTmcException;

    /**
     * 移除用户推送
     * @param nick
     */
    void removeTmc(String nick) throws TbTmcException;

    /**
     * 批量查用户推送情况
     * @param nicks
     * @return
     */
    Map<String,TmcUserVO> listTmc(List<String> nicks);

    /**
     * 淘宝下架商品
     * @param numIid
     * @param nick
     * @throws TbItemSynException
     */
    void downTbGoods(Long numIid, String nick) throws TbItemSynException;
}
