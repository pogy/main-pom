package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.GoodsFile;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_goodsFileMapper")
@Scope("singleton")
@Lazy(true)
public interface GoodsFileMapper extends Mapper<GoodsFile> {
    /**
     * 替换前置路径
     * @param from  开头的
     * @param to  替换后的开头
     */
    int replaceFileDir(@Param("from") String from, @Param("to") String to);
}
