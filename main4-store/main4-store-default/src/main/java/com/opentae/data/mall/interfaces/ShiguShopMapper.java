package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.ShiguShop;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.List;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_shiguShopMapper")
@Scope("singleton")
@Lazy(true)
public interface ShiguShopMapper extends Mapper<ShiguShop> {

    /** 查询淘宝授权同步信息 */
    ShiguShop selectTbAuthSyn(@Param("shopId") Long shopId);


    List<ShiguShop> selectShopForMarketList(@Param("floorId") Long floorId);

    List<ShiguShop> selectShopForMarketListByFloorIds(@Param("floorIds") List<Long> floorIds);

    /** 市场页店铺查询 */
    List<ShiguShop> selectShopListByShopIdsForMarketList(@Param("shopIdList") List<Long> shopIdList);

    /** 查询是否存在已经的域名 */
    Long selectDoaminRepeatById(@Param("domain") String domain, @Param("shopId") Long shopId, @Param("shopNum") String shopNum);

    @Deprecated
    Long selShopIdByNumId(@Param("storeNumId") Long shopNumId);
}
