package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.ShiguStoreNum;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_shiguStoreNumMapper")
@Scope("singleton")
@Lazy(true)
@Deprecated
public interface ShiguStoreNumMapper extends Mapper<ShiguStoreNum> {

    int updateStoreNumByStoreId(@Param("storeId") Long storeId, @Param("storeNum") String storeNum);
}
