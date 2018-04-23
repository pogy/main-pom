package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.GoodsUpCountForsearch;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.Set;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_goodsUpCountForsearchMapper")
@Scope("singleton")
@Lazy(true)
public interface GoodsUpCountForsearchMapper extends Mapper<GoodsUpCountForsearch> {

    void updatList(@Param("goodsIds") Set<Long> goodsIds, @Param("goodsUpNum") long goodsUpNum);
}
