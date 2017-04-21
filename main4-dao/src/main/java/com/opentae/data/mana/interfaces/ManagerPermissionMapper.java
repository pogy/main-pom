package com.opentae.data.mana.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mana.beans.ManagerPermission;
import com.opentae.data.mana.beans.RolePermission;
import com.opentae.data.mana.beans.UserPermission;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.List;

/**
 * 权限表
 * Created by zhaohongbo on 16/5/10.
 */
@MyBatisRepository("tae_mana_managerPermissionMapper")
@Scope("singleton")
@Lazy(true)
public interface ManagerPermissionMapper extends Mapper<ManagerPermission>{

    List<UserPermission> selPermissionByUserId(@Param("userId")Long userId);

    List<RolePermission> selPermissiontagsByroleIds(@Param("roleIds")String roleIds);

    List<RolePermission> selPermissiontagsByroleTag(@Param("roleTag")String roleTag);

    List<RolePermission> selPermissiontagsByroleIdsAndPid(@Param("roleIds")String roleIds,@Param("pids")String pids);
}
