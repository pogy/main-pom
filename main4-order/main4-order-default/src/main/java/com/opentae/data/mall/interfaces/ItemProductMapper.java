package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.ItemProduct;
import com.opentae.data.mall.beans.ItemProductInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 *
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_itemProductMapper")
@Scope("singleton")
@Lazy(true)
public interface ItemProductMapper extends Mapper<ItemProduct> {

    /**
     * 查询唯一产品
     * @param goodsId 商品ID
     * @param color 颜色
     * @param size 尺码
     * @return 产品ID
     */
    ItemProductInfo selProduct(@Param("goodsId") Long goodsId, @Param("color") String color, @Param("size") String size);
}
