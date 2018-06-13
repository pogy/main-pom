package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.ShiguHelpcenterLevel2;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.List;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_shiguHelpcenterLevel2Mapper")
@Scope("singleton")
@Lazy(true)
public interface ShiguHelpcenterLevel2Mapper extends Mapper<ShiguHelpcenterLevel2> {
    List<ShiguHelpcenterLevel2> getLevelTowByGid(int gid);
    void save(ShiguHelpcenterLevel2 shiguHelpcenterLevel2) throws Exception;
    void del(ShiguHelpcenterLevel2 shiguHelpcenterLevel2) throws Exception;
    void updata(ShiguHelpcenterLevel2 shiguHelpcenterLevel2) throws Exception;
}
