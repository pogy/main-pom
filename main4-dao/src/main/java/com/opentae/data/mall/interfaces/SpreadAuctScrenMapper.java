package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.SpreadAuctScren;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 *
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_spreadAuctScrenMapper")
@Scope("singleton")
@Lazy(true)
public interface SpreadAuctScrenMapper extends Mapper<SpreadAuctScren> {

    /** 当前活动 */
    SpreadAuctScren selectSpreadScrenNow(@Param("spreadTypeId") Long spreadTypeId);

    /** 上一期活动 */
    SpreadAuctScren selectSpreadScrenPre(@Param("spreadTypeId") Long spreadTypeId);

    /** 下一期活动 */
    SpreadAuctScren selectSpreadScrenNext(@Param("spreadTypeId") Long spreadTypeId);
}
