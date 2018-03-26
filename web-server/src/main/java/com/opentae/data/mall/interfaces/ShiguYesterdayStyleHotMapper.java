package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.ShiguYesterdayStyleHot;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_shiguYesterdayStyleHotMapper")
@Scope("singleton")
@Lazy(true)
public interface ShiguYesterdayStyleHotMapper extends Mapper<ShiguYesterdayStyleHot> {
}
