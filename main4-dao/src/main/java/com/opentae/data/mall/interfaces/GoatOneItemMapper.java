package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.GoatOneItem;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_goatOneItemMapper")
@Scope("singleton")
@Lazy(true)
public interface GoatOneItemMapper extends Mapper<GoatOneItem> {
    Integer selTypeByGoatId(@Param("goatId") Long goatId);
}
