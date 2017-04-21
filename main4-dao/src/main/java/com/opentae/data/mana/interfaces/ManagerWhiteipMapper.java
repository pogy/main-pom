package com.opentae.data.mana.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mana.beans.ManagerWhiteip;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * 白名单
 * Created by zhaohongbo on 16/5/20.
 */
@MyBatisRepository("tae_mana_managerWhiteipMapper")
@Scope("singleton")
@Lazy(true)
public interface ManagerWhiteipMapper extends Mapper<ManagerWhiteip> {
}
