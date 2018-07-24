package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.MemberUser;
import com.opentae.data.mall.beans.ShiguBonusRecord;
import com.opentae.data.mall.custombeans.BalanceVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.List;

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
    List<Long> getUserBonusBalance(@Param("userId") Long userId);

    /** 用户红包记录 */
    List<ShiguBonusRecord> getUserBonusRecord(@Param("userId") Long userId);

    /**
     * 用户余额信息
     * @param userId
     * @return
     */
    BalanceVO userBalanceInfo(@Param("userId") Long userId);
}
