package com.shigu.main4.item.services;

import com.shigu.main4.item.exceptions.ItemModifyException;
import com.shigu.main4.item.exceptions.ItemUpdateException;
import com.shigu.main4.item.exceptions.SystemSynItemException;
import com.shigu.main4.item.vo.SynItem;

import java.util.List;

/**
 * 商品添加或更新服务类
 * Created by zhaohongbo on 17/2/23.
 */
public interface ItemAddOrUpdateService {
    /**
     * 系统上架一款商品
     * @param itemId 商品主键
     */
    void systemUpItem(Long itemId) throws ItemModifyException;

    /**
     * 用户上架一款商品
     * @param itemId
     */
    void userUpItem(Long itemId) throws ItemModifyException;
    /**
     * 系统下架一款商品
     * @param itemId
     */
    void systemDownItem(Long itemId) throws ItemModifyException;

    /**
     * 用户下架一款商品
     */
    void userDownItem(Long itemId) throws ItemModifyException;

    /**
     * 系统删除一款商品
     * @param itemId
     */
    void systemDeleteItem(Long itemId) throws ItemModifyException;
    /**
     * 用户删除一款商品
     * @param itemId
     */
    void userDeleteItem(Long itemId) throws ItemModifyException;
    /**
     * 系统添加一款商品
     * @param item
     * @return
     */
    Long systemAddItem(SynItem item) throws ItemModifyException;

    /**
     * 系统同步一批商品
     * @param items
     */
    void systemSynSomeItems(List<SynItem> items) throws SystemSynItemException;

    /**
     * 用户添加一款商品
     * @return
     */
    Long userAddItem(SynItem item) throws ItemModifyException;

    /**
     * 系统更新一款商品
     * @param item
     * @return
     */
    int systemUpdateItem(SynItem item) throws ItemModifyException;

    /**
     * 用户更新一款商品
     * 暂时不用
     * @param item
     * @return
     */
    int userUpdateItem(SynItem item) throws ItemModifyException;

    /**
     * 按淘宝numIid查商品
     * @param numIid
     * @return
     */
    SynItem selItemWithSynItem(Long numIid,Long shopId);

    /**
     * 按商品主键获取商品
     * @param goodsId 商品ID
     * @param webSite 分站
     * @return 商品通讯对象
     */
    SynItem selItemByGoodsId(Long goodsId, String webSite);

    /**
     * 查询是否有更新
     * @param item
     * @return
     */
    boolean hasUpdated(SynItem item);

    /**
     * 添加图片到图搜引擎
     * @param goodsId
     * @param url
     * @param type
     */
    void addImgToSearch(Long goodsId,String webSite,String oldUrl,String url,int type);

    /**
     * 修改商品风格
     * @param goodsId 商品ID
     * @param webSite 分站
     * @param sids 风格ID
     */
    void addGoodsStyle(Long goodsId, String webSite, String sids) throws ItemUpdateException;
    /**
     * 设置商品风格
     * @param goodsId 商品ID
     * @param webSite
     */
   void setCustomStyle(Long goodsId, Long sid, String webSite);



    /**
     * 添加自定义风格
     * @param categoryId
     * @param goodsStyleName
     * @param userId
     * @return
     */
   Long addCustomerStyle(Long categoryId, String goodsStyleName, Long userId);

    /**
     * 修改自定义风格
     * @param categoryId
     * @param goodsStyleName
     * @param userId
     *
     */
   Long updateCustomerStyle(Long categoryId, Long goodsStyleId, String goodsStyleName, Long userId);

    /**
     * 删除自定义风格
     * @param goodsStyleId
     * @param userId
     * @param website
     * @param shopId
     */
    void deleteCustomerStyle(Long goodsStyleId, Long userId, String website, Long shopId);

    /**
     * 移动商品风格排序
     * @param goodsStyleId
     * @param sortType
     */
    void moveSortCustomerStyle(Long goodsStyleId, Integer sortType);
}
