package com.opentae.data.mana.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mana.beans.ManagerJiekou;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mana_managerJiekouMapper")
@Scope("singleton")
@Lazy(true)
public interface ManagerJiekouMapper extends Mapper<ManagerJiekou> {
}
