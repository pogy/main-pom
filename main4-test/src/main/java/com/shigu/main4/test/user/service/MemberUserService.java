package com.shigu.main4.test.user.service;


import com.opentae.data.mall.beans.MembeSubRepeatVo;
import com.opentae.data.mall.beans.MemberUserPhoneRepeatVo;
import com.opentae.data.mall.beans.MemberUserSub;
import com.opentae.data.mall.beans.MemberUserSubCopy2;
import com.opentae.data.mall.examples.MemberUserSubExample;
import com.opentae.data.mall.interfaces.MemberUserCopy2Mapper;
import com.opentae.data.mall.interfaces.MemberUserSubCopy2Mapper;
import com.shigu.main4.common.tools.SendPhoneMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * 会员数据整理SERVICE
 *
 * @author shigu_zjb
 * @date 2017/3/14 13:21
 *
 */
@Service("test_memberUserService")
public class MemberUserService {

    @Autowired
    private MemberUserCopy2Mapper memberUserCopy2Mapper;

    @Autowired
    private MemberUserSubCopy2Mapper memberUserSubCopy2Mapper;

    /**
     * 清理删除无主账号的子账号
     */
    @Transactional(rollbackFor = Exception.class)
    public void delNotMemberUserSub(){
        memberUserSubCopy2Mapper.delMemberSubNoMaster();
    }

    /**
     * 子账号对应两个主账号
     *
     * <p>子账号主账号类别user_name对于主账号，子账号的user却不和主账号user_id对应</p>
     *
     * 筛选规则：1、用户名不能变。2、直接判断username对应的userid和userid哪个有店铺或者余额。
     *
     * 问题：1、子账户的username是否是唯一的
     *
     */
    public void memberUserSubRepeatUser(){
        List<MembeSubRepeatVo> memberUserSubList = memberUserSubCopy2Mapper.selMembeSubRepeat();
        if(memberUserSubList.size() == 0){
            return;
        }
        List<Long> userIdList = new ArrayList<Long>();
        for(int i = 0;i<memberUserSubList.size();i++){
            MembeSubRepeatVo memberUserSub = memberUserSubList.get(i);
            MemberUserSubExample userSubExample = new MemberUserSubExample();
            userSubExample.createCriteria().andSubUserNameEqualTo(memberUserSub.getSubUserName()).andAccountTypeEqualTo(7);
            List<MemberUserSubCopy2> memberUserSubLists = memberUserSubCopy2Mapper.selectByExample(userSubExample);
            if(memberUserSubLists.size() == 0){
                continue;
            }

            List<Long> zuserIdList = new ArrayList<Long>();
            boolean pansA = false;
            for(int j = 0;j<memberUserSubLists.size();j ++){
                MemberUserSubCopy2 memberUserSubCopy2 = memberUserSubLists.get(j);
                int shopInt = memberUserCopy2Mapper.selShopIntByUserId(memberUserSubCopy2.getUserId());

                if(shopInt > 0){
                    pansA = true;
                    continue;
                }
                Long priceMoney = memberUserCopy2Mapper.selXzbTotalMoney(memberUserSubCopy2.getUserId());
                if(priceMoney != null && priceMoney > 0){
                    pansA = true;
                    continue;
                }
                zuserIdList.add(memberUserSubCopy2.getUserId());
            }
            if(!pansA){
                // 所有相同的userName都不存在有效的店铺或者余额。则第一个唯有效
                zuserIdList.remove(0);
            }
            userIdList.addAll(zuserIdList);
        }
       if(userIdList.size() == 0){
            return;
       }

        // 删除子账户数据
        memberUserSubCopy2Mapper.delMemberSubByUserIds(userIdList);
        // 删除主账户数据
        memberUserCopy2Mapper.delMemberUserByIds(userIdList);
    }

    /**
     * 同一个手机号，被2个以上的账号绑定
     */
    public void memberUserLoginPhoneRepeat(){
        List<MemberUserPhoneRepeatVo> memberUserPhoneRepeatVoList = memberUserCopy2Mapper.selLoginPhoneRepeat();
//        List<Long> userIdList = new ArrayList<Long>();
        for(int i = 0;i<memberUserPhoneRepeatVoList.size();i++){
            MemberUserPhoneRepeatVo memberUserPhoneRepeatVo = memberUserPhoneRepeatVoList.get(i);
            String [] userIds = memberUserPhoneRepeatVo.getUserIds().split(",");
            // 筛选存在的店铺存在有余额
            for(int j = 0;j<userIds.length;j++){
                //如果某个user_name为手机号,保留这个,清除其它的手机绑定
                //如果全部user_name都不是本手机号,保留最后一次绑定的手机
            }
        }
    }


    @Transactional(rollbackFor = Exception.class)
    public void clearUserData(){
        delNotMemberUserSub();
        memberUserSubRepeatUser();
        memberUserLoginPhoneRepeat();
    }

    /**
     * 同一个手机号,两个账号
     */
    public void samePhoneTwoUser(){


    }

}
