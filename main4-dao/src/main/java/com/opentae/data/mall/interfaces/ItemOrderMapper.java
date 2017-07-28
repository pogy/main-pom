package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.ItemOrder;
import com.opentae.data.mall.beans.OrderInfos;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_itemOrderMapper")
@Scope("singleton")
@Lazy(true)
public interface ItemOrderMapper extends Mapper<ItemOrder> {
    OrderInfos selOrderInfoDetailByOrderId(@Param("oid") Long orderId);
}
