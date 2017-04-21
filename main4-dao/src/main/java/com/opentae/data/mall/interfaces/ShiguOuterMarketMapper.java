package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.ShiguOuterMarket;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.List;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_shiguOuterMarketMapper")
@Scope("singleton")
@Lazy(true)
public interface ShiguOuterMarketMapper extends Mapper<ShiguOuterMarket> {

    List<ShiguOuterMarket> selOuterMarketListByBo(@Param("website") String website);

    int selOuterMarketCountByBo(@Param("website") String website);
}
