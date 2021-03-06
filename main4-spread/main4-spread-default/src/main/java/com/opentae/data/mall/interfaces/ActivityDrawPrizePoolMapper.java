package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.ActivityDrawPrizePool;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_activityDrawPrizePoolMapper")
@Scope("singleton")
@Lazy(true)
public interface ActivityDrawPrizePoolMapper extends Mapper<ActivityDrawPrizePool> {

    void addProvide(@Param("pemId") Long pemId, @Param("rank") Integer rank);
}
