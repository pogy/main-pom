package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_itemCidWeightMapper")
@Scope("singleton")
@Lazy(true)
public interface ItemCidWeightMapper extends Mapper<ItemCidWeight> {
}
