package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.ShopFitmentArea;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_shopFitmentAreaMapper")
@Scope("singleton")
@Lazy(true)
public interface ShopFitmentAreaMapper extends Mapper<ShopFitmentArea> {
    /**
     * 统计本页内除自己以外的区域
     * @param areaId
     * @return
     */
    int countAreaNome(@Param("areaId") Long areaId);
}
