package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.beans.ShiguStore;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.List;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_shiguStoreMapper")
@Scope("singleton")
@Lazy(true)
@Deprecated
public interface ShiguStoreMapper extends Mapper<ShiguStore> {

    ShiguStore selectStoreRelationByIdWebSite(@Param("storeId") Long storeId ,@Param("website") String website);

    int updateStoreRelationByIdWebSite(@Param("store") ShiguStore shiguStore ,@Param("website") String website);

    List<ShiguShop> selShopQyList();

}
