package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.ShiguGoodsCollect;
import com.opentae.data.mall.beans.TinyItemCollect;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.List;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_shiguGoodsCollectMapper")
@Scope("singleton")
@Lazy(true)
public interface ShiguGoodsCollectMapper extends Mapper<ShiguGoodsCollect> {

    List<TinyItemCollect> tinyGoodsCollect(
            @Param("userId")Long userId,
            @Param("keyword") String keyword,
            @Param("webSite")String webSite,
            @Param("start")int start,
            @Param("size")int size
    );
    int countTinyGoodsCollect(@Param("userId")Long userId,@Param("keyword") String keyword,
                              @Param("webSite")String webSite);
}
