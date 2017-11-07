package com.shigu.main4.item.services;


import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.item.bo.StoreGoodsListSearchBO;
import com.shigu.main4.item.enums.ShopCountRedisCacheEnum;
import com.shigu.main4.item.exceptions.ItemException;
import com.shigu.main4.item.vo.*;

/**
 * 店内宝贝服务
 * Created by zhaohongbo on 17/3/2.
 */
public interface ShopsItemService {
    /**
     * 查出售中的商品
     *
     * @param keyword  宝贝名称
     * @param shopId   店铺ID
     * @param pageNo   当前页
     * @param pageSize 每页条数
     * @return
     */
    @Deprecated
    ShiguPager<OnsaleItem> selOnsaleItems(String keyword, String goodsNo, Long numIid, Long shopId, int pageNo, int pageSize) throws ItemException;

    /**
     * 给修复宝贝提供数据
     * 实际是查出淘宝过来的商品
     *
     * @param keyword
     * @param goodsId
     * @param shopId
     * @param pageNo
     * @param pageSize
     * @return
     */
    ShiguPager<XiufuItem> selXiufuItem(String keyword, Long goodsId, Long shopId, int pageNo, int pageSize) throws ItemException;

    /**
     * 查仓库中的商品
     *
     * @param keyword  宝贝名称
     * @param goodsNo  货号
     * @param numIid   淘宝宝贝ID
     * @param shopId   店铺ID
     * @param pageNo   当前页
     * @param pageSize 每页条数
     * @return
     */
    ShiguPager<InstockItem> selInstockItems(String keyword, String goodsNo, Long numIid, Long shopId, int pageNo, int pageSize) throws ItemException;

    /**
     * 店内商品统计
     *
     * @param shopId
     * @return
     */
    ItemCount selItemCount(Long shopId) throws ItemException;

    /**
     * 获取商品图片下载压缩包链接
     *
     * @param goodsId
     * @return
     */
    String itemImgzipUrl(Long goodsId);

    /**
     * 出售中的商品改版
     * @param shopId
     * @param webSite
     * @param bo
     * @param pageNo
     * @param pageSize
     * @return
     * @throws Main4Exception
     */
    ShiguPager<OnsaleItem> selOnsaleItems(Long shopId, String webSite, StoreGoodsListSearchBO bo, int pageNo, int pageSize) throws Main4Exception;

    /**
     * 更新材质信息
     * @param goodsId
     * @param shopId
     * @param webSite
     * @param fabricStr
     * @param inFabricStr
     * @throws JsonErrException
     */
    void setConstituent(Long goodsId,Long shopId,String webSite,String fabricStr,String inFabricStr) throws JsonErrException;

    /**
     * 清除店铺商品统计数据缓存
     * @param shopId
     * @param type
     */
    void clearShopCountCache(Long shopId, ShopCountRedisCacheEnum type);

    int countOnsaleGoodsAggrNum(Long shopId,String webSite,ShopCountRedisCacheEnum aggrType);

    /**
     * 商品详情页查看是否设置过最低零售价
     * @param goodsId
     * @return
     */
    boolean checkHasLowestLiPriceSet(Long goodsId) throws Main4Exception;

}
