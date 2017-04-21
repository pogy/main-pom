package com.shigu.sysman.member.service;


import com.opentae.data.mall.beans.MemberUser;
import com.opentae.data.mall.beans.MemberUserSub;
import com.opentae.data.mall.examples.MemberUserExample;
import com.opentae.data.mall.examples.MemberUserSubExample;
import com.opentae.data.mall.interfaces.MemberUserSubMapper;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.sysman.member.bo.MemberUserBo;
import com.shigu.sysman.member.bo.MemberUserSubBo;
import com.shigu.sysman.member.vo.MemberUserSubVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 会员子账号SERVICE
 *
 * @author shigu_zjb
 * @date 2017/04/04 15:49
 *
 */
@Service
public class MemberUserSubService {

    @Resource(name = "tae_mall_memberUserSubMapper")
    private MemberUserSubMapper memberUserSubMapper;

    /**
     * 用户子账号列表
     * @param memberUserSubBo
     * @return
     */
    public List<MemberUserSubVo> findMemberUserSubList(MemberUserSubBo memberUserSubBo){
        if(memberUserSubBo == null){
            memberUserSubBo = new MemberUserSubBo();
        }
        MemberUserSubExample userExample = createMemberUserSubExample(memberUserSubBo);
        List<MemberUserSub> memberUserList = new ArrayList<MemberUserSub>();
        if (memberUserSubBo.isPageBoolean()) {
            memberUserList = memberUserSubMapper.selectByConditionList(userExample);
        } else {
            memberUserList = memberUserSubMapper.selectByExample(userExample);
        }
        List<MemberUserSubVo> MemberUserSubVoList = BeanMapper.mapList(memberUserList, MemberUserSubVo.class);
        return MemberUserSubVoList;
    }

    /**
     * 记录数
     * @param memberUserSubBo
     * @return
     */
    public int countMemberUserByBo(MemberUserSubBo memberUserSubBo){
        if(memberUserSubBo == null){
            memberUserSubBo = new MemberUserSubBo();
        }
        MemberUserSubExample userExample = createMemberUserSubExample(memberUserSubBo);
        int count = memberUserSubMapper.countByExample(userExample);
        return count;
    }

    /**
     * 创建条件example
     * @param memberUserSubBo
     * @return
     */
    public MemberUserSubExample createMemberUserSubExample(MemberUserSubBo memberUserSubBo){
        MemberUserSubExample userExample = new MemberUserSubExample();
        MemberUserSubExample.Criteria crt = userExample.createCriteria();
        if(memberUserSubBo.isPageBoolean()){
            // 需要分页
            userExample.setStartIndex(memberUserSubBo.getStartRow());
            userExample.setEndIndex(memberUserSubBo.getStartRow() + memberUserSubBo.getPageSize());
        }
        if(memberUserSubBo.getUserId() != null){
            crt.andUserIdEqualTo(memberUserSubBo.getUserId());
        }
        return userExample;
    }

    /**
     * 用户子账号分页列表
     * @param memberUserBo
     * @return
     */
    public ShiguPager<MemberUserSubVo> findMemberUserSubPager(MemberUserSubBo memberUserBo){
        if(memberUserBo == null){
            memberUserBo = new MemberUserSubBo();
        }
        List<MemberUserSubVo> MemberUserSubVoList = findMemberUserSubList(memberUserBo);
        int count = countMemberUserByBo(memberUserBo);
        ShiguPager<MemberUserSubVo> shiguPager = new ShiguPager<MemberUserSubVo>();
        shiguPager.setContent(MemberUserSubVoList);
        shiguPager.calPages(count,memberUserBo.getPageSize());
        shiguPager.setNumber(memberUserBo.getCurrentPage());
        return shiguPager;
    }


}
