package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.GoodsPiPriceError;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_goodsPiPriceErrorMapper")
@Scope("singleton")
@Lazy(true)
public interface GoodsPiPriceErrorMapper extends Mapper<GoodsPiPriceError> {
}
