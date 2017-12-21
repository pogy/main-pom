package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.GoodsCountForsearch;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_goodsCountForsearchMapper")
@Scope("singleton")
@Lazy(true)
public interface GoodsCountForsearchMapper extends Mapper<GoodsCountForsearch> {
    //统计某个类目关联自定义风格的商品
    int countGoodsByStyles(@Param("userId") Long userId,@Param("cId") String cId, @Param("webSite") String webSite);

    //统计某个关联自定义风格的商品
    int countGoodsByStyle(@Param("userId") Long userId,@Param("sid") Integer sid, @Param("webSite") String webSite);

}
