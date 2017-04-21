package com.opentae.data.mana.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mana.beans.ManagerRole;
import com.opentae.data.mana.beans.UserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.List;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mana_managerRoleMapper")
@Scope("singleton")
@Lazy(true)
public interface ManagerRoleMapper extends Mapper<ManagerRole> {
    List<UserRole> selRoleNamesByuserIds(@Param("userIds")String userIds);
}
