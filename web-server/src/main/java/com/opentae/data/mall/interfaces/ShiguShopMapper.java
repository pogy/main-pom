package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.beans.ShopNumAndMarket;
import com.shigu.seller.vo.DataListVO;
import com.shigu.seller.vo.DownlaodDataVO;
import com.shigu.seller.vo.WeekReadDataVO;
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

    /** 店铺COUNT */
    int selectShopCountByBo(@Param("website")String website, @Param("userName")String userName,
                            @Param("userId")Long userId, @Param("marketId") Long marketId, @Param("floorId")Long floorId,
                            @Param("shopId")Long shopId, @Param("taobaoUrl")String taobaoUrl, @Param("shopName")String shopName,
                            @Param("shopNum") String shopNum);

    List<ShopNumAndMarket> selShopNumAndMarkets(@Param("shopIdList") List<Long> shopIdList);

    ShopNumAndMarket selMarketInfo(@Param("shopId") Long shopId);
}
