package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_shiguGoodsTinyMapper")
@Scope("singleton")
@Lazy(true)
public interface ShiguGoodsTinyMapper extends Mapper<ShiguGoodsTiny> {

    int updateImAliwwByStoreId(@Param("website") String website, @Param("storeId") Long storeId,
                               @Param("imAliww") String imAliww, @Param("storeNum") String storeNum);

    /** 更新店铺关店状态 */
    int updateGoodsTinyByClose(@Param("website") String website, @Param("oldClosed") int oldClosed,
                               @Param("newClosed") int newClosed, @Param("shopId") Long shopId);

    /** 修改floorMarket */
    int updateFloorMarketByShopId(@Param("storeId") Long storeId, @Param("website") String website, @Param("marketId") Long marketId,
                                  @Param("floorId") Long floorId);

    /**
     * 获取店铺展示商品总数
     * @param shopId
     * @param webSite
     * @return
     */
    Integer selectGoodsCountByShopId(@Param("shopId") Long shopId,@Param("webSite") String webSite);
}
