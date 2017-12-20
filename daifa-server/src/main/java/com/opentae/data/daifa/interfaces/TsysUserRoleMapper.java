package com.opentae.data.daifa.interfaces;

import com.opentae.data.daifa.beans.TsysUserRole;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.Lazy;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.core.mybatis.config.MyBatisRepository;
/**
 *==========================================================
 *TODO ->这里需要配置 主要是这个类的描述信息
 *@类编号：
 *@类名称：TsysUserRoleMapper.java
 *@文件路径：com.opentae.data.daifa.interfaces.TsysUserRoleMapper
 *@内容摘要：
 *@编码作者：自动生成
 *@完成日期：
 *@Date2017-08-09 04:20:50
 *@comments:
 *@since 1.0
 *=========================================================
 */
@MyBatisRepository("tae_daifa_tsysUserRoleMapper")
@Scope("singleton")
@Lazy(true)
public interface TsysUserRoleMapper extends Mapper<TsysUserRole>{

}
