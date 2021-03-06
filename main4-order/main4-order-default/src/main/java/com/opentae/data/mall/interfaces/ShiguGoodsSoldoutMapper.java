package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.ShiguGoodsSoldout;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_shiguGoodsSoldoutMapper")
@Scope("singleton")
@Lazy(true)
public interface ShiguGoodsSoldoutMapper extends Mapper<ShiguGoodsSoldout> {

    /** 查询下架的商品 */
    ShiguGoodsSoldout selectGoodsSoldoutById(@Param("goodsId") Long goodsId, @Param("webSite") String webSite);

}
