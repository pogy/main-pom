package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.ShiguTaobaocat;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
/**
 *==========================================================
 *TODO ->这里需要配置 主要是这个类的描述信息
 *@类编号：
 *@类名称：ShiguTaobaocatMapper.java
 *@文件路径：com.opentae.data.mall.interfaces.ShiguTaobaocatMapper
 *@内容摘要：
 *@编码作者：自动生成
 *@完成日期：
 *@Date2017-11-03 02:22:10
 *@comments:
 *@since 1.0
 *=========================================================
 */
@MyBatisRepository("tae_mall_shiguTaobaocatMapper")
@Scope("singleton")
@Lazy(true)
public interface ShiguTaobaocatMapper extends Mapper<ShiguTaobaocat>{

}
