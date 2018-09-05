package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.ShiguGoodsTinyCreatedQz;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_shiguGoodsTinyCreatedMapper")
@Scope("singleton")
@Lazy(true)
public interface ShiguGoodsTinyCreatedQzMapper extends Mapper<ShiguGoodsTinyCreatedQz> {
}
