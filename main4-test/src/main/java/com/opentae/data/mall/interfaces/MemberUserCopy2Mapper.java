package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.DfUserNamePhone;
import com.opentae.data.mall.beans.MemberUserCopy2;
import com.opentae.data.mall.beans.MemberUserPhoneRepeatVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.List;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_memberUserCopy2Mapper")
@Scope("singleton")
@Lazy(true)
public interface MemberUserCopy2Mapper extends Mapper<MemberUserCopy2> {

    /** 手机号绑定了两个以上的用户 */
    List<MemberUserPhoneRepeatVo> selLoginPhoneRepeat();

    List<String> selMemberSubRepeat();

    List<DfUserNamePhone> usernamePhoneDf();

    List<Long> selUserNamByTb();

    List<Long> nosubUser();

    List<String> selDoubleSubUserName();

    Long selyue(@Param("userId") Long userId);

    /**
     * 一个账号下,一个类型有两个账户
     * @return
     */
    List<String> selDoubleSubUser();

    /** 用户拥有的店铺 */
    int selShopIntByUserId(@Param("userId") Long userId);

    /** 账户余额 */
    Long selXzbTotalMoney(Long userId);

    /** 删除主账号数据 */
    int delMemberUserByIds(@Param("userIdList") List<Long> userIdList);

}
