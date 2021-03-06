package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.EnlistEgg;
import com.opentae.data.mall.beans.SpreadEnlist;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.List;

/**
 *
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_spreadEnlistMapper")
@Scope("singleton")
@Lazy(true)
public interface SpreadEnlistMapper extends Mapper<SpreadEnlist> {

    /**
     * @return
     */
    List<SpreadEnlist> romSelectData(@Param("activityId")Long activityId ,@Param("num")Integer num);

    List<EnlistEgg> selEgg(@Param("sort")String sort, @Param("shopId")Long shopId, @Param("start")Integer start, @Param("size")Integer size);

}
