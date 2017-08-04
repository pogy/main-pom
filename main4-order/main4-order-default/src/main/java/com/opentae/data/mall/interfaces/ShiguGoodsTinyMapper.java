package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.ItemForList;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.List;

/**
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_shiguGoodsTinyMapper")
@Scope("singleton")
@Lazy(true)
public interface ShiguGoodsTinyMapper extends Mapper<ShiguGoodsTiny> {

    List<ItemForList> selItemsForList(@Param("website") String website, @Param("goodsIds") List<Long> goodsIds);

    /**
     * 下架的商品
     * @param website
     * @param goodsIds
     * @return
     */
    List<ItemForList> selSoldItemsForList(@Param("website") String website, @Param("goodsIds") List<Long> goodsIds);

}
