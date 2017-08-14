package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.MemberUserSub;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.List;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_memberUserSubMapper")
@Scope("singleton")
@Lazy(true)
public interface MemberUserSubMapper extends Mapper<MemberUserSub> {

    /** 根据分组[username]查询用户子账户信息 */
    List<MemberUserSub> selectUserSubListByUserName(@Param("userId") Long userId, @Param("startRows") int startRows,
                                                    @Param("pageSize") int pageSize);

}
