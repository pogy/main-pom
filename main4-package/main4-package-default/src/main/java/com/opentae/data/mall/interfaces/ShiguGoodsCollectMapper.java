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

    /**
     * 数据包搜索
     * @param userId
     * @param keyword
     * @param webSite
     * @param start
     * @param size
     * @return
     */
    List<TinyItemCollect> tinyGoodsCollect(
            @Param("userId")Long userId,
            @Param("keyword") String keyword,
            @Param("webSite")String webSite,
            @Param("start")int start,
            @Param("size")int size
    );

    /**
     * 数据包计数
     * @param userId
     * @param keyword
     * @param webSite
     * @return
     */
    int countTinyGoodsCollect(@Param("userId")Long userId,@Param("keyword") String keyword,
                              @Param("webSite")String webSite);
}
