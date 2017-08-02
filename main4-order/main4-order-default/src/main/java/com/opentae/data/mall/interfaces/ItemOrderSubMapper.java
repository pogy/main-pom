package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.ItemOrderSub;
import com.opentae.data.mall.beans.SubOrderInfos;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.List;

/**
 *
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_itemOrderSubMapper")
@Scope("singleton")
@Lazy(true)
public interface ItemOrderSubMapper extends Mapper<ItemOrderSub> {
    List<SubOrderInfos> selSubOrderAndRefundInfos(@Param("oid") Long oid);
}
