package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_shiguGoodsTinyMapper")
@Scope("singleton")
@Lazy(true)
public interface ShiguGoodsTinyMapper extends Mapper<ShiguGoodsTiny> {

    //获取档口中无大图商品数量
    int selNoBigPic(@Param("shopId") Long shopId,@Param("webSite") String webSite);
    //获取档口中未设置最低零售价商品数量
    int selNoLowPrice(@Param("shopId") Long shopId,@Param("webSite") String webSite);
    //获取未设置面料成分商品数量
    int selNoConstituent(@Param("shopId") Long shopId,@Param("webSite") String webSite);


}
