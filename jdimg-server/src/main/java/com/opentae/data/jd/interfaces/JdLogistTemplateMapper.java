package com.opentae.data.jd.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.jd.beans.JdLogistTemplate;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_jd_jdLogistTemplateMapper")
@Scope("singleton")
@Lazy(true)
public interface JdLogistTemplateMapper extends Mapper<JdLogistTemplate> {
}
