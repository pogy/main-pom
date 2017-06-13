package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.MemberLicenseApply;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.List;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_memberLicenseApplyMapper")
@Scope("singleton")
@Lazy(true)
public interface MemberLicenseApplyMapper extends Mapper<MemberLicenseApply> {

    /**
     * 查询会员权益申请
     */
    List<MemberLicenseApply> selectLicenseApplyListByBo(@Param("userName") String userName, @Param("mobiles") String mobiles,
                                                        @Param("applyStatus") Long applyStatus, @Param("userId") Long userId,
                                                        @Param("startRow") Integer startRow, @Param("endRow") Integer endRow);

    /** 查询权益记录 */
    int selectLicenseApplyCountByBo(@Param("userName") String userName, @Param("mobiles") String mobiles,
                                    @Param("applyStatus") Long applyStatus, @Param("userId") Long userId);
}
