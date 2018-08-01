package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.ItemOrderVoucherRelation;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_itemOrderVoucherRelationMapper")
@Scope("singleton")
@Lazy(true)
public interface ItemOrderVoucherRelationMapper extends Mapper<ItemOrderVoucherRelation> {
}
