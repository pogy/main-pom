package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.ShopVideoTime;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_shopVideoTimeMapper")
@Scope("singleton")
@Lazy(true)
public interface ShopVideoTimeMapper extends Mapper<ShopVideoTime> {
    public int insert(ShopVideoTime shopVideoTime);

    public void update(ShopVideoTime shopVideoTime);

    public int delete(ShopVideoTime shopVideoTime);
}
