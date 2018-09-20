package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.ShiguMarketActivityGoods;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_shiguMarketActivityGoodsMapper")
@Scope("singleton")
@Lazy(true)
public interface ShiguMarketActivityGoodsMapper extends Mapper<ShiguMarketActivityGoods> {
}
