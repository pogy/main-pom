package com.opentae.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.mall.beans.MemberUser;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_com.opentae.mall_memberUserMapper")
@Scope("singleton")
@Lazy(true)
public interface MemberUserMapper extends Mapper<MemberUser> {
}
