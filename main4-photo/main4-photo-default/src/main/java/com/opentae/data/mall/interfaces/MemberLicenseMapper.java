package com.opentae.data.mall.interfaces;

import com.opentae.data.mall.beans.MemberLicense;
import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_com.opentae.mall_memberLicenseMapper")
@Scope("singleton")
@Lazy(true)
public interface MemberLicenseMapper extends Mapper<MemberLicense> {
}
