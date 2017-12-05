package com.shigu.main4;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.ActiveDrawGoods;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_activeDrawGoodsMapper")
@Scope("singleton")
@Lazy(true)
public interface ActiveDrawGoodsMapper extends Mapper<ActiveDrawGoods> {
}
