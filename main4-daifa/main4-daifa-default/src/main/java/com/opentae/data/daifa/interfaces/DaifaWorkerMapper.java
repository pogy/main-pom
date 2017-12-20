package com.opentae.data.daifa.interfaces;

import com.opentae.data.daifa.beans.DaifaWorker;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.Lazy;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.core.mybatis.config.MyBatisRepository;
/**
 *==========================================================
 *TODO ->这里需要配置 主要是这个类的描述信息
 *@类编号：
 *@类名称：DaifaWorkerMapper.java
 *@文件路径：com.opentae.data.daifa.interfaces.DaifaWorkerMapper
 *@内容摘要：
 *@编码作者：自动生成
 *@完成日期：
 *@Date2017-08-09 04:19:57
 *@comments:
 *@since 1.0
 *=========================================================
 */
@MyBatisRepository("tae_daifa_daifaWorkerMapper")
@Scope("singleton")
@Lazy(true)
public interface DaifaWorkerMapper extends Mapper<DaifaWorker>{

}
