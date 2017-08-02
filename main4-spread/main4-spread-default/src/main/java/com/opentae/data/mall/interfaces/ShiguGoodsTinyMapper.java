package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.ItemForList;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.List;

/**
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_shiguGoodsTinyMapper")
@Scope("singleton")
@Lazy(true)
public interface ShiguGoodsTinyMapper extends Mapper<ShiguGoodsTiny> {

    int updateImAliwwByStoreId(@Param("website") String website, @Param("storeId") Long storeId,
                               @Param("imAliww") String imAliww, @Param("storeNum") String storeNum);

    /** 批量查询 */
    List<ShiguGoodsTiny> selectGoodsByIds(@Param("website") String website, @Param("goodIds") Long[] goodIds);

    /** 查询 */
    ShiguGoodsTiny selectGoodsById(@Param("website") String website, @Param("goodsId") Long goodsId);

    /** 更新店铺关店状态 */
    int updateGoodsTinyByClose(@Param("website") String website, @Param("oldClosed") int oldClosed,
                               @Param("newClosed") int newClosed, @Param("shopId") Long shopId);

    /** 修改floorMarket */
    int updateFloorMarketByShopId(@Param("storeId") Long storeId, @Param("website") String website, @Param("marketId") Long marketId,
                                  @Param("floorId") Long floorId);

    int udpateGoodsModifiedForSynShop(@Param("website") String website, @Param("storeId") Long storeId);

    List<ItemForList> selItemsForList(@Param("website") String website, @Param("goodsIds") List<Long> goodsIds);

    /**
     * 下架的商品
     * @param website
     * @param goodsIds
     * @return
     */
    List<ItemForList> selSoldItemsForList(@Param("website") String website, @Param("goodsIds") List<Long> goodsIds);

    List<ShiguGoodsTiny> selectGoodsTinyListByBo(@Param("website") String website, @Param("goodsId") Long goodsId, @Param("gtSortOrder") Long gtSortOrder,
                                                 @Param("startRow") int startRow, @Param("pageSize") int pageSize);

    int selectGoodsTinyCountByBo(@Param("website") String website, @Param("goodsId") Long goodsId, @Param("gtSortOrder") Long gtSortOrder);
}
