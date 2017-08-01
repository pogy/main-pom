package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.MemberUser;
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

    /** 根据手机号查找用户信息 */
    List<MemberUser> selectMemberByNameOrPhone(@Param("phone") String phone);

    /** 用户列表 */
    List<MemberUser> selectMemberUserListByBo(@Param("userName") String userName, @Param("userNick") String userNick,
                                              @Param("loginPhone") String loginPhone, @Param("subUserName") String subUserName,
                                              @Param("startRow") int startRow, @Param("pageSize") int PageSize);

    /** 用户记录数 */
    int selectMemberUserCountByBo(@Param("userName") String userName, @Param("userNick") String userNick,
                                  @Param("loginPhone") String loginPhone, @Param("subUserName") String subUserName);

}
