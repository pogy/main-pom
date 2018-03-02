package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.ShiguHelpcenterLevel1;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_shiguHelpcenterLevel1Mapper")
@Scope("singleton")
@Lazy(true)
public interface ShiguHelpcenterLevel1Mapper extends Mapper<ShiguHelpcenterLevel1> {
    void save(ShiguHelpcenterLevel1 shiguHelpcenterLevel1) throws Exception;
    void del(ShiguHelpcenterLevel1 shiguHelpcenterLevel1) throws Exception;
    void updata(ShiguHelpcenterLevel1 shiguHelpcenterLevel1) throws Exception;
}
