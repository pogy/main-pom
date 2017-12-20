package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.DiscusRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.List;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_discusRecordMapper")
@Scope("singleton")
@Lazy(true)
public interface DiscusRecordMapper extends Mapper<DiscusRecord> {

    /** 评论信息 */
    List<DiscusRecord> selectShopDiscusRecord(@Param("shopId") Long shopId, @Param("startRows") int startRows,
                                              @Param("pageSize") int pageSize);

    /** 评论信息COUNT */
    int selectShopDiscusRecordCount(@Param("shopId") Long shopId);

}
