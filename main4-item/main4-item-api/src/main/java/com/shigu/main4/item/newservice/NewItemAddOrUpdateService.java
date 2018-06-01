package com.shigu.main4.item.newservice;

import com.shigu.main4.item.bo.news.NewPushSynItemBO;
import com.shigu.main4.item.exceptions.ItemModifyException;
import com.shigu.main4.item.vo.news.NewPullSynItemVO;

/**
 * 商品添加或更新服务类
 * Created by zhaohongbo on 17/2/23.
 */
public interface NewItemAddOrUpdateService {
    /**
     * 系统添加一款商品
     * @param item
     * @return
     */
    Long systemAddItem(NewPushSynItemBO item) throws ItemModifyException;
    /**
     * 用户添加一款商品
     * @return
     */
    Long userAddItem(NewPushSynItemBO item) throws ItemModifyException;

    /**
     * 系统更新一款商品
     * @param item
     * @return
     */
    int systemUpdateItem(NewPushSynItemBO item) throws ItemModifyException;
    /**
     * 系统后台更新一款商品,操作和userUpdateItem一样,就是取消shigu_goods_modify的修改
     * sites.admin工程专用方法
     * @param item
     * @return
     */
    int officeUpdateItem(NewPushSynItemBO item) throws ItemModifyException;
    /**
     * 用户更新一款商品
     * 暂时不用
     * @param item
     * @return
     */
    int userUpdateItem(NewPushSynItemBO item) throws ItemModifyException;
    /**
     * 用户更新一款商品
     * 暂时不用
     * @param item
     * @return
     */
    int userUpdateItem(NewPushSynItemBO item, Boolean updatePrice) throws ItemModifyException;
    /**
     * 按商品主键获取商品
     * @param goodsId 商品ID
     * @param webSite 分站
     * @return 商品通讯对象
     */
    NewPullSynItemVO selItemByGoodsId(Long goodsId, String webSite);
    /**
     * 按淘宝numIid查商品
     * @param numIid
     * @return
     */
    NewPullSynItemVO selItemWithSynItem(Long numIid,Long shopId);
}
