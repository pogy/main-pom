package com.shigu.main4.member;

import com.opentae.data.mall.beans.DfUserNamePhone;
import com.opentae.data.mall.beans.MemberLicense;
import com.opentae.data.mall.beans.MemberUser;
import com.opentae.data.mall.beans.MemberUserPhoneRepeatVo;
import com.opentae.data.mall.beans.MemberUserSub;
import com.opentae.data.mall.examples.MemberLicenseExample;
import com.opentae.data.mall.examples.MemberUserExample;
import com.opentae.data.mall.examples.MemberUserSubExample;
import com.opentae.data.mall.examples.ShiguShopExample;
import com.opentae.data.mall.interfaces.MemberLicenseMapper;
import com.opentae.data.mall.interfaces.MemberUserCopy2Mapper;
import com.opentae.data.mall.interfaces.MemberUserMapper;
import com.opentae.data.mall.interfaces.MemberUserSubCopy2Mapper;
import com.opentae.data.mall.interfaces.MemberUserSubMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhaohongbo on 17/3/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( value="/ac.xml" )
public class DeleteMemberTest {

    @Autowired
    private MemberUserMapper memberUserMapper;

    @Autowired
    private MemberUserSubMapper memberUserSubMapper;

    @Autowired
    private MemberUserCopy2Mapper memberUserCopy2Mapper;

    @Autowired
    private MemberUserSubCopy2Mapper memberUserSubCopy2Mapper;

    @Autowired
    private MemberLicenseMapper memberLicenseMapper;

    @Autowired
    private ShiguShopMapper shiguShopMapper;
    /**
     * 清理1个手机号,被多个用户绑定的情况
     * 1、如果所有账号里,有1个user_name为手机号,那么保留这个
     * 2、如果没有user_name为手机号的,保留user_id最大的那个
     */
    @Test
    public void delRepeatPhone(){
        List<MemberUserPhoneRepeatVo> list=memberUserCopy2Mapper.selLoginPhoneRepeat();
        for(MemberUserPhoneRepeatVo vo:list){
            String userIds=vo.getUserIds();
            String[] userIdArr=userIds.split(",");
            boolean hasFind=false;
            for(int i=0;i<userIdArr.length;i++){
                Long userId=Long.valueOf(userIdArr[i]);
                MemberUser user=memberUserMapper.selectByPrimaryKey(userId);
                if(user.getUserName().equals(vo.getLoginPhone())){
                    hasFind=true;
                    bind(userId,vo.getLoginPhone());
                }else{
                    if(i+1==userIdArr.length&&!hasFind){//到最后一个都没找到,就绑一下
                        bind(userId,vo.getLoginPhone());
                    }else{
                        jiebind(userId);
                    }
                }
            }
        }
    }

    /**
     * 用户与手机号解绑
     */
    public void jiebind(Long userId){
        MemberUser user=new MemberUser();
        user.setUserId(userId);
        user.setLoginPhone("");
        memberUserMapper.updateByPrimaryKeySelective(user);
        MemberLicenseExample example=new MemberLicenseExample();
        example.createCriteria().andUserIdEqualTo(userId).andLicenseTypeEqualTo(4);
        memberLicenseMapper.deleteByExample(example);
    }

    /**
     * 用户与手机号绑定
     * @param userId
     * @param phone
     */
    public void bind(Long userId,String phone){
        MemberUser user=memberUserMapper.selectByPrimaryKey(userId);
        if(isPhone(user.getUserName())){
            MemberUser upuser=new MemberUser();
            upuser.setUserId(userId);
            upuser.setUserName(phone);
            memberUserMapper.updateByPrimaryKeySelective(upuser);
            MemberUserSub upusersub=new MemberUserSub();
            upusersub.setUserId(userId);
            upusersub.setSubUserName(phone);
            MemberUserSubExample example=new MemberUserSubExample();
            example.createCriteria().andUserIdEqualTo(userId).andAccountTypeEqualTo(7);
            memberUserSubMapper.updateByExampleSelective(upusersub,example);
        }
        if(isPhone(user.getUserNick())){
            MemberUser upuser=new MemberUser();
            upuser.setUserId(userId);
            upuser.setUserNick(phone);
            memberUserMapper.updateByPrimaryKeySelective(upuser);
        }
        //如果userName或userNick是手机格式的,update
        MemberLicenseExample example=new MemberLicenseExample();
        example.createCriteria().andUserIdEqualTo(userId).andLicenseTypeEqualTo(4);
        List<MemberLicense> list=memberLicenseMapper.selectByExample(example);
        if(list.size()==0){
            MemberLicense license=new MemberLicense();
            license.setUserId(userId);
            license.setContext(phone);
            license.setLicenseType(4);
            license.setLicenseFailure(1);
            memberLicenseMapper.insertSelective(license);
        }else{
            MemberLicense license=new MemberLicense();
            license.setContext(phone);
            memberLicenseMapper.updateByExampleSelective(license,example);
        }

    }

    /**
     * 是否手机格式
     * @param str
     * @return
     */
    public boolean isPhone(String str){
        Pattern pattern = Pattern.compile("^((14[0-9])|(13[0-9])|(15[^4,\\D])|(18[012356789])|(17[012356789]))\\d{8}$");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    /**
     * 清理1个主账号下挂多个星座子账号的情况
     * 1、查出有多个子账号的账户
     * 2、保留与主账号user_name一样的那个子账号
     */
    @Test
    public void delRepeatSubUser(){
        List<String> subids=memberUserCopy2Mapper.selMemberSubRepeat();
        for(String ids:subids){
            String[] idarr=ids.split(",");
            boolean hasFind=false;
            for(String idstr:idarr){
                Long subuserId=Long.valueOf(idstr);
                MemberUserSub sub=memberUserSubMapper.selectByPrimaryKey(subuserId);
                MemberUser user=memberUserMapper.selectByPrimaryKey(sub.getUserId());
                if(user==null||!sub.getSubUserName().equals(user.getUserName())||hasFind){
                    memberUserSubMapper.deleteByPrimaryKey(subuserId);
                }else{
                    hasFind=true;
                }
            }
        }
    }

    /**
     * 账号是手机号,绑定的是另外的手机号
     * 1、把主表user_name改成bind手机号
     * 2、把子表user_name改成bind手机号
     */
    @Test
    public void modUserNameByDfBind(){
        List<DfUserNamePhone> list=memberUserCopy2Mapper.usernamePhoneDf();
        for(DfUserNamePhone dunp:list){
            bind(dunp.getUserId(),dunp.getLoginPhone());
        }
    }

    /**
     * 重复子账号
     */
    @Test
    public void doubleSub(){
        List<String> subs=memberUserCopy2Mapper.selDoubleSubUser();
        System.out.println(subs.size());
        for(String sub:subs){
            String[] subarr=sub.split(",");
            for(int i=1;i<subarr.length;i++){
                memberUserSubMapper.deleteByPrimaryKey(Long.valueOf(subarr[i]));
            }
        }
    }

    @Test
    public void doubleSubUserName(){
        List<String> uids=memberUserCopy2Mapper.selDoubleSubUserName();
        for(String uid:uids){
            String[] uidarr=uid.split(",");
//            if(uidarr[0].equals(uidarr[1])){
//                continue;
//            }
            //找到没有手机绑定的一个
            Long unPhoneUser=null;
            for(int i=1;i<uidarr.length;i++){
//            for(String u:uidarr){
                memberUserSubMapper.deleteByPrimaryKey(Long.valueOf(uidarr[i]));
//                MemberLicenseExample example=new MemberLicenseExample();
//                example.createCriteria().andUserIdEqualTo(Long.valueOf(u));
//                List<MemberLicense> licenses=memberLicenseMapper.selectByExample(example);
//                MemberUserSubExample subExample=new MemberUserSubExample();
//                subExample.createCriteria().andUserIdEqualTo(Long.valueOf(u)).andAccountTypeEqualTo(3);
//                if(licenses.size()>0){
//                    continue;
//                }else if(memberUserSubMapper.countByExample(subExample)>0){
//                    continue;
//                }else{
//                    unPhoneUser=Long.valueOf(u);
//                }
            }
//            if(unPhoneUser==null){
//                continue;
//            }
//            //找到没有余额的
//            Long yue=memberUserCopy2Mapper.selyue(unPhoneUser);
//            if(yue!=null&&yue>0){
//                continue;
//            }
//            //找到没有开店的
//            ShiguShopExample shopExample=new ShiguShopExample();
//            shopExample.createCriteria().andUserIdEqualTo(unPhoneUser);
//            if(shiguShopMapper.countByExample(shopExample)>0){
//                continue;
//            }
//            //删除主表、子表、权益表
//            memberUserMapper.deleteByPrimaryKey(unPhoneUser);
//            MemberUserSubExample subExample=new MemberUserSubExample();
//            subExample.createCriteria().andUserIdEqualTo(unPhoneUser);
//            memberUserSubMapper.deleteByExample(subExample);
//            MemberLicenseExample licenseExample=new MemberLicenseExample();
//            licenseExample.createCriteria().andUserIdEqualTo(unPhoneUser);
//            memberLicenseMapper.deleteByExample(licenseExample);
        }
    }

    @Test
    public void selyue(){
        System.out.println(memberUserCopy2Mapper.selyue(100001325L));
    }


    @Test
    public void modUserNameFromTaobao(){
        List<Long> list=memberUserCopy2Mapper.selUserNamByTb();
        for(Long userId:list){
            MemberLicenseExample example=new MemberLicenseExample();
            example.createCriteria().andUserIdEqualTo(userId).andLicenseTypeEqualTo(4);
            List<MemberLicense> licenses=memberLicenseMapper.selectByExample(example);
            if(licenses.size()>0){
                MemberUser user=new MemberUser();
                user.setUserId(userId);
                user.setUserName(licenses.get(0).getContext());
                memberUserMapper.updateByPrimaryKeySelective(user);
                MemberUserSub userSub=new MemberUserSub();
                userSub.setSubUserName(licenses.get(0).getContext());
                MemberUserSubExample subExample=new MemberUserSubExample();
                subExample.createCriteria().andUserIdEqualTo(userId).andAccountTypeEqualTo(7);
                memberUserSubMapper.updateByExampleSelective(userSub,subExample);
            }else{
//                MemberUser olduser=memberUserMapper.selectByPrimaryKey(userId);
//                MemberUser user=new MemberUser();
//                user.setUserId(userId);
//                user.setUserName(olduser.getUserName()+"__bad__");
//                memberUserMapper.updateByPrimaryKeySelective(user);
//                MemberUserSub userSub=new MemberUserSub();
//                userSub.setSubUserName(olduser.getUserName()+"__bad__");
//                MemberUserSubExample subExample=new MemberUserSubExample();
//                subExample.createCriteria().andUserIdEqualTo(userId).andAccountTypeEqualTo(7);
//                memberUserSubMapper.updateByExampleSelective(userSub,subExample);
            }
        }
    }

    @Test
    public void createPhoneLicense(){
        MemberUserExample example=new MemberUserExample();
        example.createCriteria().andLoginPhoneIsNotNull().andLoginPhoneNotEqualTo("");
        List<MemberUser> list=memberUserMapper.selectByExample(example);
        for(MemberUser user:list){
            if(isPhone(user.getLoginPhone())){
                MemberLicenseExample example1=new MemberLicenseExample();
                example1.createCriteria().andUserIdEqualTo(user.getUserId()).andLicenseTypeEqualTo(4);
                if(memberLicenseMapper.countByExample(example1)>0){
                    continue;
                }
                MemberLicense license=new MemberLicense();
                license.setLicenseType(4);
                license.setContext(user.getLoginPhone());
                license.setUserId(user.getUserId());
                memberLicenseMapper.insertSelective(license);
            }
        }
    }

    @Test
    public void createSubUser(){
        List<Long> userIds=memberUserCopy2Mapper.nosubUser();
        for(Long uid:userIds){
            MemberUserSubExample example=new MemberUserSubExample();
            example.createCriteria().andUserIdEqualTo(uid).andAccountTypeEqualTo(7);
            if(memberUserSubMapper.countByExample(example)==0){
                MemberUser user=memberUserMapper.selectByPrimaryKey(uid);
                MemberUserSub userSub=new MemberUserSub();
                userSub.setSubUserName(user.getUserName());
                userSub.setUserId(user.getUserId());
//            userSub.setSubUserKey(tempUser.getSubUserKey());
                userSub.setAccountType(7);
                userSub.setLogins(0);
                userSub.setUseStatus(1);
                memberUserSubMapper.insertSelective(userSub);
            }
        }
    }



}
