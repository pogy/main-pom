package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.GoatItem;
import com.opentae.data.mall.beans.GoatItemWithField;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.List;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_goatItemMapper")
@Scope("singleton")
@Lazy(true)
public interface GoatItemMapper extends Mapper<GoatItem> {

    List<GoatItemWithField> selItemsWithField(@Param("locationId")Long locationId);
}
