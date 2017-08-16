package com.opentae.data.daifa.interfaces;

import com.opentae.data.daifa.beans.TsysRole;
import com.opentae.data.daifa.examples.TsysRoleExample;
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
 *@类名称：TsysRoleMapper.java
 *@文件路径：com.opentae.data.daifa.interfaces.TsysRoleMapper
 *@内容摘要：
 *@编码作者：自动生成
 *@完成日期：
 *@Date2017-08-09 04:20:42
 *@comments:
 *@since 1.0
 *=========================================================
 */
@MyBatisRepository("tae_daifa_tsysRoleMapper")
@Scope("singleton")
@Lazy(true)
public interface TsysRoleMapper extends Mapper<TsysRole>{
    List<TsysRole> selectUserRoleTreeByExample (TsysRoleExample example);

    List<TsysRole> selRoleNamesByuserIds (@Param("userIds") String userIds);

    List<TsysRole> selRoleBySellerId (@Param("createUserId") Long createUserId);
}
