package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.DiscusScore;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_discusScoreMapper")
@Scope("singleton")
@Lazy(true)
public interface DiscusScoreMapper extends Mapper<DiscusScore> {

    /** 平均分统计 */
    Double selectAvgScore(@Param("shopId") Long shopId);

}
