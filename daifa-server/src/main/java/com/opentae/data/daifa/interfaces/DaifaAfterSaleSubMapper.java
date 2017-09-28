package com.opentae.data.daifa.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.daifa.beans.DaifaAfterSaleSub;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_daifa_daifaAfterSaleSubMapper")
@Scope("singleton")
@Lazy(true)
public interface DaifaAfterSaleSubMapper extends Mapper<DaifaAfterSaleSub> {

    Integer selectAfterCount(@Param("sellerId")Long sellerId,@Param("afterType")Integer afterType);
}
