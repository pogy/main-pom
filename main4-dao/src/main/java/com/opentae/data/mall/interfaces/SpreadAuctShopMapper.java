package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.SpreadAuctShop;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.List;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_spreadAuctShopMapper")
@Scope("singleton")
@Lazy(true)
@Deprecated
public interface SpreadAuctShopMapper extends Mapper<SpreadAuctShop> {

    /** 广告竞拍列表 */
    List<SpreadAuctShop> selectSpreadShopListByBo(@Param("shopId")Long shopId, @Param("screnId") Long screnId ,
                                                  @Param("draw") Boolean draw);
}
