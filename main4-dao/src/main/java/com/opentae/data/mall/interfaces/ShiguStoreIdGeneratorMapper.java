package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.ShiguStoreIdGenerator;
import com.opentae.data.mall.beans.StoreAuthDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.List;

/**
 * Created by zhaohongbo on 16/7/22.
 */
@MyBatisRepository("tae_mall_managerJiekouMapper")
@Scope("singleton")
@Lazy(true)
@Deprecated
public interface ShiguStoreIdGeneratorMapper extends Mapper<ShiguStoreIdGenerator> {

    Long selMarketId(@Param("storeId")Long storeId,@Param("webSite")String webSite);
    List<StoreAuthDetail> selStoreAuth(@Param("mid")Long mid,@Param("webSite")String webSite);

    String selSessionById(@Param("storeId")Long storeId,@Param("webSite")String webSite,@Param("appKey")String appKey);

    Long selSessionIdByStoreId(@Param("storeId")Long storeId,@Param("webSite")String webSite,@Param("appKey")String appKey);

    void guoqiSessionMap(@Param("tsmId")Long tsmId);
    void guoqiStore(@Param("storeId")Long storeId,@Param("webSite")String webSite);

    /** 店铺生成信息 */
    ShiguStoreIdGenerator selectStoreGenById(@Param("storeId") Long storeId);
}
