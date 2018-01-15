package com.shigu.main4.ucenter.services;

import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.ucenter.exceptions.ItemCollectionException;
import com.shigu.main4.ucenter.exceptions.ShopCollectionException;
import com.shigu.main4.ucenter.vo.DataPackage;
import com.shigu.main4.ucenter.vo.ItemCollect;
import com.shigu.main4.ucenter.vo.ShopCollect;
import com.shigu.main4.ucenter.webvo.*;

import java.util.List;

/**
 * 用户收藏类服务
 * Created by zhaohongbo on 17/2/23.
 */
public interface UserCollectService {
    /**
     * 查询本店收藏的宝贝
     * @param userId 用户ID
     * @param webSite 分站标识
     * @param pageNo 当前页码
     * @param pageSize 每页条数
     * @return
     */
    @Deprecated
    ShiguPager<ItemCollectVO> selItemCollections(Long userId,String keyword, String webSite,int pageNo,int pageSize);

    ShiguPager<NewGoodsCollectVO> selItemCollectionsByType(Long userId, String keyword, String webSite, int pageNo, int pageSize, int type);
    /**
     * 按主键批量删除收藏记录
     * @param userId 用户ID
     * @param collectIds 主键
     */
    void delItemCollection(Long userId,List<Long> collectIds);
    /**
     * 查询收藏宝贝信息
     * @param userId 用户ID
     * @param goodsId 商品ID
     * @param webSite 分站标识
     * @return
     */
    ItemCollectInfoVO selItemCollectionInfo(Long userId, Long goodsId, String webSite);

    /**
     * 按条件查询收藏商品
     * @param userId
     * @param goodsId
     * @param useStatus
     * @param storeId
     * @param webSite
     * @return
     */
    List<ItemCollectInfoVO> selItemCollection(Long userId, Long goodsId, Integer useStatus, Long storeId, String webSite);
    /**
     * 添加商品收藏
     * @param collect
     */
    void addItemCollection(ItemCollect collect) throws ItemCollectionException;

    /**
     * 生成商品数据包
     * @param userId
     * @param itemIds
     * @return
     */
    boolean createDataPackage(Long userId,List<Long> itemIds);

    /**
     * 生成数据包 根据数据包IDs
     * @param userId
     * @param collectIdList
     * @return
     */
    boolean createDataPackageByCoolectIds(Long userId,List<Long> collectIdList);

    /**
     * 查询数据包
     * @param userId
     * @param pageNo
     * @param pageSize
     * @return
     */
    ShiguPager<DataPackage> selPackages(Long userId,int pageNo,int pageSize);

    /**
     * 按包主键删除数据包
     * @param userId
     * @param packageIds
     */
    void delPackagesById(Long userId,List<Long> packageIds);

    /**
     * 店铺收藏
     * @param userId 用户ID
     * @param webSite 分站标识
     * @param pageNo 当前页
     * @param pageSize 每页条数
     * @return
     */
    ShiguPager<ShopCollectVO> selShopCollections(Long userId,String webSite,int pageNo,int pageSize);

    /**
     * 按主键删除店铺收藏
     * @param userId
     * @param collectIds
     */
    void delShopCollection(Long userId,List<Long> collectIds);

    /**
     * 添加店铺收藏
     * @param collect
     */
    void addShopCollection(ShopCollect collect) throws ShopCollectionException;

    List<ShopInfo> selShopInfoByShopIds(List<Long> shopIds);
}
