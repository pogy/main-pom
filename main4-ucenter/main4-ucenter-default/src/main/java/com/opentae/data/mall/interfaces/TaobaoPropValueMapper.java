package com.opentae.data.mall.interfaces;

import com.opentae.data.mall.beans.TaobaoPropValue;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.Lazy;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.core.mybatis.config.MyBatisRepository;
/**
 *==========================================================
 *TODO ->这里需要配置 主要是这个类的描述信息
 *@类编号：
 *@类名称：TaobaoPropValueMapper.java
 *@文件路径：com.opentae.data.mall.interfaces.TaobaoPropValueMapper
 *@内容摘要：
 *@编码作者：自动生成
 *@完成日期：
 *@Date2017-11-03 06:01:29
 *@comments:
 *@since 1.0
 *=========================================================
 */
@MyBatisRepository("tae_mall_taobaoPropValueMapper")
@Scope("singleton")
@Lazy(true)
public interface TaobaoPropValueMapper extends Mapper<TaobaoPropValue>{

}
