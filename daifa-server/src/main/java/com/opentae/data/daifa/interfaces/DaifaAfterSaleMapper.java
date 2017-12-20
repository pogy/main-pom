package com.opentae.data.daifa.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.daifa.beans.DaifaAfterSale;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.List;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_daifa_daifaAfterSaleMapper")
@Scope("singleton")
@Lazy(true)
public interface DaifaAfterSaleMapper extends Mapper<DaifaAfterSale> {
    List<DaifaAfterSale> selectAfterSaleOrder(
            @Param("orderId") String orderId,
            @Param("telephone") String telephone,
            @Param("backPostCode") String backPostCode,
            @Param("startTime") String startTime,
            @Param("endTime") String endTime,
            @Param("status") Integer status,
            @Param("sellerId") Long sellerId,
            @Param("startIndex") Integer startIndex,
            @Param("endIndex") Integer endIndex);

    Integer countAfterSaleSub( @Param("backPostCode") String backPostCode,
                               @Param("status") Integer status,
                               @Param("sellerId") Long sellerId);
}
