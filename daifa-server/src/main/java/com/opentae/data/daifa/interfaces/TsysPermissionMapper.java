package com.opentae.data.daifa.interfaces;

import com.opentae.data.daifa.beans.TsysPermission;
import com.opentae.data.daifa.beans.TsysRole;
import com.opentae.data.daifa.examples.TsysPermissionExample;
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
 *@类名称：TsysPermissionMapper.java
 *@文件路径：com.opentae.data.daifa.interfaces.TsysPermissionMapper
 *@内容摘要：
 *@编码作者：自动生成
 *@完成日期：
 *@Date2017-08-09 04:20:34
 *@comments:
 *@since 1.0
 *=========================================================
 */
@MyBatisRepository("tae_daifa_tsysPermissionMapper")
@Scope("singleton")
@Lazy(true)
public interface TsysPermissionMapper extends Mapper<TsysPermission>{
    List<TsysRole> selectRolePermissionTreeByExample(TsysPermissionExample example);

    List<TsysPermission> selPermissiontagsByroleTag(@Param("roleTag")String roleTag);
}
