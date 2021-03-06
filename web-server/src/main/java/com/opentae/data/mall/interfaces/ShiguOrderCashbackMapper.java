package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.ShiguOrderCashback;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_shiguOrderCashbackMapper")
@Scope("singleton")
@Lazy(true)
public interface ShiguOrderCashbackMapper extends Mapper<ShiguOrderCashback> {
    Integer updateCashback(@Param("cashback") ShiguOrderCashback cashback);
}
