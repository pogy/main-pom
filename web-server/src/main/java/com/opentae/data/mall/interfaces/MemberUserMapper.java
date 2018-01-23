package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.MemberUser;
import com.opentae.data.mall.beans.ShiguBonusRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.List;
import java.util.Map;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_memberUserMapper")
@Scope("singleton")
@Lazy(true)
public interface MemberUserMapper extends Mapper<MemberUser> {
    /** 用户余额 */
    Long userBalance(@Param("userId") Long userId);
    
    Long userXzbAccount(@Param("userId") Long userId);

    /** 用户红包余额 */
    Long getUserBonusBalance(String thirdId);

    /** 用户红包记录 */
    List<ShiguBonusRecord> getUserBonusRecord(String thirdId);
}
