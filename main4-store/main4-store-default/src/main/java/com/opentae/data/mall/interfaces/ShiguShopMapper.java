package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.beans.ShopNumAndMarket;
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

    /** 店铺列表 */
    List<ShiguShop> selectShopListByBo(@Param("website") String website, @Param("userName") String userName,
                                       @Param("userId") Long userId, @Param("marketId") Long marketId, @Param("floorId") Long floorId,
                                       @Param("shopId") Long shopId, @Param("taobaoUrl") String taobaoUrl, @Param("tbNick") String tbNick,
                                       @Param("shopNum") String shopNum, @Param("startRow") int startRow, @Param("pageSize") int pageSize);

    /** 店铺COUNT */
    int selectShopCountByBo(@Param("website") String website, @Param("userName") String userName,
                            @Param("userId") Long userId, @Param("marketId") Long marketId, @Param("floorId") Long floorId,
                            @Param("shopId") Long shopId, @Param("taobaoUrl") String taobaoUrl, @Param("shopName") String shopName,
                            @Param("shopNum") String shopNum);

    List<ShiguShop> selectShopForMarketList(@Param("floorId") Long floorId);

    List<String> selectShopNumByIds(@Param("shopIdList") List<String> shopIdList);

    /** 市场页店铺查询 */
    List<ShiguShop> selectShopListByShopIdsForMarketList(@Param("shopIdList") List<Long> shopIdList);

    /** 查询是否存在已经的域名 */
    Long selectDoaminRepeatById(@Param("domain") String domain, @Param("shopId") Long shopId, @Param("shopNum") String shopNum);

    List<ShopNumAndMarket> selShopNumAndMarkets(@Param("shopIdList") List<Long> shopIdList);

    @Deprecated
    Long selShopIdByNumId(@Param("storeNumId") Long shopNumId);
}
