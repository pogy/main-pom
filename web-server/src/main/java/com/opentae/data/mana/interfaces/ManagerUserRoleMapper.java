package com.opentae.data.mana.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mana.beans.ManagerUserRole;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * 用户角色对应表
 * Created by zhaohongbo on 16/5/10.
 */
@MyBatisRepository("tae_mana_managerUserRoleMapper")
@Scope("singleton")
@Lazy(true)
public interface ManagerUserRoleMapper extends Mapper<ManagerUserRole>{
}
