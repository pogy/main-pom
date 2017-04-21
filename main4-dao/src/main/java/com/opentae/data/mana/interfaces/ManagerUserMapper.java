package com.opentae.data.mana.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mana.beans.ManagerUser;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * 用户表
 * Created by zhaohongbo on 16/5/10.
 */
@MyBatisRepository("tae_mana_managerUserMapper")
@Scope("singleton")
@Lazy(true)
public interface ManagerUserMapper extends Mapper<ManagerUser>{
}
