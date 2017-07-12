package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.ShiguActivityApprove;
import com.opentae.data.mall.beans.ShiguActivityCategory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * Created by Administrator on 2017/7/12.
 */

@MyBatisRepository("tae_mall_shiguActivityCategoryMapper")
@Scope("singleton")
@Lazy(true)
public interface ShiguActivityCategoryMapper extends Mapper<ShiguActivityCategory> {
}
