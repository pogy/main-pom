package com.opentae.data.daifa.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.daifa.beans.DaifaTradeBackup1;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 *==========================================================
 *TODO ->这里需要配置 主要是这个类的描述信息
 *@类编号：
 *@类名称：DaifaTradeMapper.java
 *@文件路径：com.opentae.data.daifa.interfaces.DaifaTradeMapper
 *@内容摘要：
 *@编码作者：自动生成
 *@完成日期：
 *@Date2017-08-09 04:19:38
 *@comments:
 *@since 1.0
 *=========================================================
 */
@MyBatisRepository("tae_daifa_daifaTradeBackup1Mapper")
@Scope("singleton")
@Lazy(true)
public interface DaifaTradeBackup1Mapper extends Mapper<DaifaTradeBackup1>{
}
