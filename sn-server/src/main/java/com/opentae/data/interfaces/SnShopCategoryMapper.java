package com.opentae.data.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.beans.SnShopCategory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_beans.SnShopCategory_snShopCategoryMapper")
@Scope("singleton")
@Lazy(true)
public interface SnShopCategoryMapper extends Mapper<SnShopCategory> {
}
