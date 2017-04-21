package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.MembeSubRepeatVo;
import com.opentae.data.mall.beans.MemberUserSubCopy2;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.List;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_memberUserSubCopy2Mapper")
@Scope("singleton")
@Lazy(true)
public interface MemberUserSubCopy2Mapper extends Mapper<MemberUserSubCopy2> {

    /** 清理无用主账号的子账号 */
    int delMemberSubNoMaster();

    /** 子账号对应两个主账号 */
    List<MembeSubRepeatVo> selMembeSubRepeat();

    /** 删除子账户 */
    int delMemberSubByUserIds(@Param("userIdList") List<Long> userIdList);

    /** 更新子账户的用户ID */
    int updateMemberSubUserId(@Param("newUserId") Long newUserId, @Param("subUserId")Long subUserId);

}
