package com.opentae.data.jd.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.jd.beans.JdSessionMap;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_jd_jdSessionMapMapper")
@Scope("singleton")
@Lazy(true)
public interface JdSessionMapMapper extends Mapper<JdSessionMap> {
}
