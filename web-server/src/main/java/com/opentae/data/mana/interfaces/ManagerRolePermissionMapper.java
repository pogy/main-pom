package com.opentae.data.mana.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mana.beans.ManagerRolePermission;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * Created by zhaohongbo on 16/5/12.
 */
@MyBatisRepository("tae_mana_managerRolePermissionMapper")
@Scope("singleton")
@Lazy(true)
public interface ManagerRolePermissionMapper extends Mapper<ManagerRolePermission> {

    Long selLastModifyByRoleTag(String roleTag);
}
