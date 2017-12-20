package com.opentae.data.daifa.interfaces;

import com.opentae.data.daifa.beans.DaifaGgoodsTasks;
import com.opentae.data.daifa.beans.GgoodsByStore;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.Lazy;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.core.mybatis.config.MyBatisRepository;

import java.util.List;

/**
 *==========================================================
 *TODO ->这里需要配置 主要是这个类的描述信息
 *@类编号：
 *@类名称：DaifaGgoodsTasksMapper.java
 *@文件路径：com.opentae.data.daifa.interfaces.DaifaGgoodsTasksMapper
 *@内容摘要：
 *@编码作者：自动生成
 *@完成日期：
 *@Date2017-08-09 04:19:07
 *@comments:
 *@since 1.0
 *=========================================================
 */
@MyBatisRepository("tae_daifa_daifaGgoodsTasksMapper")
@Scope("singleton")
@Lazy(true)
public interface DaifaGgoodsTasksMapper extends Mapper<DaifaGgoodsTasks>{
    /**
     * 查询根据档口分组的未分配数据
     * @param sellerId
     * @return
     */
    List<GgoodsByStore> selDaifaGoodsGroupByShop(@Param("sellerId")Long sellerId);

}
