package com.opentae.data.mall.interfaces;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.opentae.data.mall.beans.EsSynTemp;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.core.mybatis.config.MyBatisRepository;
/**
 *
 *@author 自动生成
 *@see EsSynTemp
 *@docRoot com.opentae.data.mall.interfaces.EsSynTemp
 *@remark 自动生成
 *生成日期： 2017-03-27 11:17:25
 *完成日期：
 *内容摘要：
 */
@MyBatisRepository("tae_mall_esSynTempMapper")
@Scope("singleton")
@Lazy(true)
public interface EsSynTempMapper extends Mapper<EsSynTemp>{

}
