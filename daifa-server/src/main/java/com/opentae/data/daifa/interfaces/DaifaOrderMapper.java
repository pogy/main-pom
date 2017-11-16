package com.opentae.data.daifa.interfaces;

import com.opentae.data.daifa.beans.DaifaOrder;
import com.opentae.data.daifa.examples.DaifaOrderExample;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.Lazy;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.core.mybatis.config.MyBatisRepository;

import java.util.List;

/**
 *==========================================================
 *TODO ->这里需要配置 主要是这个类的描述信息
 *@类编号：
 *@类名称：DaifaOrderMapper.java
 *@文件路径：com.opentae.data.daifa.interfaces.DaifaOrderMapper
 *@内容摘要：
 *@编码作者：自动生成
 *@完成日期：
 *@Date2017-08-09 04:18:57
 *@comments:
 *@since 1.0
 *=========================================================
 */
@MyBatisRepository("tae_daifa_daifaOrderMapper")
@Scope("singleton")
@Lazy(true)
public interface DaifaOrderMapper extends Mapper<DaifaOrder>{


    List<DaifaOrder> statisGoodsbyGoods (DaifaOrderExample example);

    List<DaifaOrder> statisGoodsByStoreNum (DaifaOrderExample example);

    int countStatisGoodsbyGoods(DaifaOrderExample example);
    int countStatisGoodsByStoreNum(DaifaOrderExample example);
}
