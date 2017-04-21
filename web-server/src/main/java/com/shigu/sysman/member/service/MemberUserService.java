package com.shigu.sysman.member.service;


import com.opentae.data.mall.beans.MemberUser;
import com.opentae.data.mall.examples.MemberUserExample;
import com.opentae.data.mall.interfaces.MemberUserMapper;
import com.opentae.data.mall.interfaces.MemberUserSubMapper;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.sysman.member.bo.MemberUserBo;
import com.shigu.sysman.member.vo.MemberUserVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 会员SERVICE
 *
 * @author shigu_zjb
 * @date 2017/04/03 13:34
 *
 */
@Service
public class MemberUserService {

    @Resource(name = "tae_mall_memberUserMapper")
    private MemberUserMapper memberUserMapper;

    @Resource(name = "tae_mall_memberUserSubMapper")
    private MemberUserSubMapper memberUserSubMapper;

    /**
     * 用户列表
     * @param memberUserBo
     * @return
     */
    public List<MemberUserVo> findMemberUserList(MemberUserBo memberUserBo){
        if(memberUserBo == null){
            memberUserBo = new MemberUserBo();
        }
        List<MemberUser> memberUserList = memberUserMapper.selectMemberUserListByBo(memberUserBo.getUserName(),memberUserBo.getUserNick()
                ,memberUserBo.getLoginPhone(), memberUserBo.getSubUserName(),memberUserBo.getStartRow(),memberUserBo.getPageSize());
        List<MemberUserVo> memberUserVoList = BeanMapper.mapList(memberUserList, MemberUserVo.class);
        return memberUserVoList;
    }

    /**
     * 记录数
     * @param memberUserBo
     * @return
     */
    public int countMemberUserByBo(MemberUserBo memberUserBo){
        if(memberUserBo == null){
            memberUserBo = new MemberUserBo();
        }
        int count = memberUserMapper.selectMemberUserCountByBo(memberUserBo.getUserName(),memberUserBo.getUserNick()
                ,memberUserBo.getLoginPhone(), memberUserBo.getSubUserName());
        return count;
    }

    /**
     * 用户分页列表
     * @param memberUserBo
     * @return
     */
    public ShiguPager<MemberUserVo> findMemberUserPager(MemberUserBo memberUserBo){
        if(memberUserBo == null){
            memberUserBo = new MemberUserBo();
        }
        memberUserBo.setPageBoolean(true);
        List<MemberUserVo> memberUserVoList = findMemberUserList(memberUserBo);
        int count = countMemberUserByBo(memberUserBo);
        ShiguPager<MemberUserVo> shiguPager = new ShiguPager<MemberUserVo>();
        shiguPager.setContent(memberUserVoList);
        shiguPager.calPages(count,memberUserBo.getPageSize());
        shiguPager.setNumber(memberUserBo.getCurrentPage());
        return shiguPager;
    }

}
