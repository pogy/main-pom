package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.ShiguPageRecode;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;



@MyBatisRepository("tae_mall_shiguPageRecodeMapper")
@Scope("singleton")
@Lazy(true)
public interface ShiguPageRecodeMapper extends Mapper<ShiguPageRecode> {

}