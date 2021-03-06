package com.opentae.data.daifa.interfaces;

import com.openJar.beans.WorkUserGgoodsTasksCounts;
import com.openJar.beans.WorkUserGgoodsTasksMarket;
import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.daifa.beans.DaifaGgoods;
import com.opentae.data.daifa.beans.DaifaGgoodsBackup1;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.List;

/**
 *==========================================================
 *TODO ->这里需要配置 主要是这个类的描述信息
 *@类编号：
 *@类名称：DaifaGgoodsMapper.java
 *@文件路径：com.opentae.data.daifa.interfaces.DaifaGgoodsMapper
 *@内容摘要：
 *@编码作者：自动生成
 *@完成日期：
 *@Date2017-08-09 04:19:03
 *@comments:
 *@since 1.0
 *=========================================================
 */
@MyBatisRepository("tae_daifa_daifaGgoodsBackup1Mapper")
@Scope("singleton")
@Lazy(true)
public interface DaifaGgoodsBackup1Mapper extends Mapper<DaifaGgoodsBackup1>{
}
