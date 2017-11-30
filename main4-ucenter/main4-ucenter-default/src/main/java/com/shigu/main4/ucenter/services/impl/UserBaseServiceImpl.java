package com.shigu.main4.ucenter.services.impl;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.MemberLicense;
import com.opentae.data.mall.beans.MemberUser;
import com.opentae.data.mall.beans.MemberUserSub;
import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.examples.MemberLicenseExample;
import com.opentae.data.mall.examples.MemberUserSubExample;
import com.opentae.data.mall.interfaces.MemberLicenseMapper;
import com.opentae.data.mall.interfaces.MemberUserMapper;
import com.opentae.data.mall.interfaces.MemberUserSubMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.ucenter.enums.MemberLicenseType;
import com.shigu.main4.ucenter.enums.OtherPlatformEnum;
import com.shigu.main4.ucenter.exceptions.UpdateUserInfoException;
import com.shigu.main4.ucenter.services.UserBaseService;
import com.shigu.main4.ucenter.services.UserLicenseService;
import com.shigu.main4.ucenter.util.EncryptUtil;
import com.shigu.main4.ucenter.vo.OuterUser;
import com.shigu.main4.ucenter.vo.SafeAbout;
import com.shigu.main4.ucenter.vo.UserInfo;
import com.shigu.main4.ucenter.vo.UserInfoUpdate;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.SysUserSession;
import com.shigu.session.main4.enums.LoginFromType;
import com.shigu.session.main4.tool.BeanMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户基本信息查询
 * Created by zhaohongbo on 17/2/15.
 */
@Service("userBaseService")
public class UserBaseServiceImpl implements UserBaseService {

    private static final Logger logger = LoggerFactory.getLogger(UserBaseServiceImpl.class);

    @Resource(name = "tae_mall_memberUserMapper")
    MemberUserMapper memberUserMapper;
    @Resource(name = "tae_mall_memberUserSubMapper")
    MemberUserSubMapper memberUserSubMapper;
    @Autowired
    MemberLicenseMapper memberLicenseMapper;

    @Autowired
    private ShiguShopMapper shiguShopMapper;
    @Autowired
    UserLicenseService userLicenseService;

    /**
     * 按用户名查用户基准信息
     * @param userName
     * @return
     */
    public PersonalSession selUserForSessionByUserName(String userName, LoginFromType type) {
        return selUserForSessionByUserName(userName,null,type);
    }

    @Override
    public PersonalSession selUserForSessionByUserName(String userName, String key, LoginFromType type) {
        //查用户子表,如果有,再查出用户主表包装PersonalSession
        MemberUserSubExample subExample=new MemberUserSubExample();
        MemberUserSubExample.Criteria cri=subExample.createCriteria().andAccountTypeEqualTo(type.getAccountType());
        if (type.equals(LoginFromType.WX)) {
            cri.andSubUserKeyEqualTo(key==null?"123321":key);
        }else{
            cri.andSubUserNameEqualTo(userName);
        }
        subExample.setStartIndex(0);
        subExample.setEndIndex(1);
        List<MemberUserSub> subs=memberUserSubMapper.selectFieldsByConditionList(subExample,
                FieldUtil.codeFields("user_id,sub_user_id"));
        if(subs.size()>0){
            MemberUserSub mus=subs.get(0);
            MemberUser memberUser=memberUserMapper.selectFieldsByPrimaryKey(mus.getUserId(),
                    FieldUtil.codeFields("user_id,user_nick,portrait_url"));
            if(memberUser==null){//数据异常
                logger.error(mus.getUserId()+"此用户,分表里有,主表里不存在!!!!!!!");
                return null;
            }
            PersonalSession ps=parseToPersonal(memberUser,mus);
            ps.setLoginFromType(type);
            ps.setLoginName(userName);
            return ps;
        }else if(type.equals(LoginFromType.PHONE)||type.equals(LoginFromType.XZ)){//如果是手机登陆的，查member的license,如果是某账号绑定的手机,查出
            MemberLicenseExample licenseExample=new MemberLicenseExample();
            licenseExample.createCriteria().andContextEqualTo(userName)
                    .andLicenseTypeEqualTo(MemberLicenseType.PHONE_BIND.getValue());
            licenseExample.setStartIndex(0);
            licenseExample.setEndIndex(1);
            List<MemberLicense> memberLicenses=memberLicenseMapper.selectFieldsByExample(licenseExample,
                    FieldUtil.codeFields("user_id"));
            if(memberLicenses.size()==0)
                return null;
            MemberUser memberUser=memberUserMapper.selectFieldsByPrimaryKey(memberLicenses.get(0).getUserId(),
                    FieldUtil.codeFields("user_id,user_nick,portrait_url"));
            //主表存在
            if(memberUser!=null){
                subExample.clear();
                subExample.createCriteria().andUserIdEqualTo(memberUser.getUserId())
                        .andAccountTypeEqualTo(LoginFromType.XZ.getAccountType());
                subs=memberUserSubMapper.selectFieldsByConditionList(subExample,
                        FieldUtil.codeFields("user_id,sub_user_id"));
                if(subs.size()>0){
                    PersonalSession ps=parseToPersonal(memberUser,subs.get(0));
                    ps.setLoginFromType(type);
                    ps.setLoginName(userName);
                    return ps;
                }
            }
        }
        return null;
    }

    /**
     * 查询绑定的手机号
     * @param userId
     * @return
     */
    private String selBindPhone(Long userId){
        MemberLicenseExample licenseExample=new MemberLicenseExample();
        licenseExample.createCriteria().andUserIdEqualTo(userId)
                .andLicenseTypeEqualTo(MemberLicenseType.PHONE_BIND.getValue()).andLicenseFailureEqualTo(1);
        licenseExample.setStartIndex(0);
        licenseExample.setEndIndex(1);
        List<MemberLicense> memberLicenses=memberLicenseMapper.selectFieldsByExample(licenseExample,
                FieldUtil.codeFields("user_id,context"));
        if(memberLicenses.size()>0){
            return memberLicenses.get(0).getContext();
        }
        return null;
    }

    /**
     * 查询是否是分销商vip
     * @param userId
     * @return
     */
    private boolean isMemberVip(Long userId){
        if (userId == null) {
            return false;
        }
        MemberLicense condition = new MemberLicense();
        condition.setUserId(userId);
        condition.setLicenseType(MemberLicenseType.MEMBER_VIP.getValue());
        condition.setLicenseFailure(1);
        return memberLicenseMapper.selectCount(condition)>0;
    }
    /**
     * 包装personalSession
     * @param memberUser
     * @param memberUserSub
     * @return
     */
    private PersonalSession parseToPersonal(MemberUser memberUser, MemberUserSub memberUserSub){
        PersonalSession ps=new PersonalSession();
        ps.setSubUserId(memberUserSub.getSubUserId());
        ps.setUserId(memberUserSub.getUserId());
        ps.setUserNick(memberUser.getUserNick());
        String url=memberUser.getPortraitUrl();
        if(url != null && url.startsWith("/SGimg/")){
            url="//sgimage.571xz.com/new_image_site"+url;
        }
        ps.setHeadUrl(url);
        String bindPhone=selBindPhone(memberUser.getUserId());
        if(bindPhone!=null){
            ps.getOtherPlatform().put(OtherPlatformEnum.BIND_PHONE.getValue(),bindPhone);
        }
        boolean isMoreOrder=false;
        SafeAbout sa=userLicenseService.selUserLicenses(memberUser.getUserId());
        try {
            if(BeanMapper.getFieldList(sa.getLicenses(),"type",MemberLicenseType.class).contains(MemberLicenseType.MORE_ORDER)){
                isMoreOrder=true;
            }
        } catch (Exception ignored) {
        }
        ps.getOtherPlatform().put(OtherPlatformEnum.MORE_ORDER.getValue(),isMoreOrder);
        ps.getOtherPlatform().put(OtherPlatformEnum.MEMBER_VIP.getValue(),isMemberVip(memberUserSub.getUserId()));
        return ps;
    }
    /**
     * 按用户Id查询密码密文
     * @param userId 不能为空
     * @return
     */
    public String selUserPwdByUserId(Long userId) {
        MemberUserSubExample subExample=new MemberUserSubExample();
        subExample.createCriteria().andAccountTypeEqualTo(LoginFromType.XZ.getAccountType()).andUserIdEqualTo(userId);
        subExample.setStartIndex(0);
        subExample.setEndIndex(1);
        List<MemberUserSub> subs=memberUserSubMapper.selectFieldsByConditionList(subExample,
                FieldUtil.codeFields("sub_user_id,sub_user_password"));
        if(subs.size()>0){
            return subs.get(0).getSubUserPassword();
        }
        return null;
    }

    public SysUserSession selSysForSessionByUserName(String userName) {
        return null;
    }

    public String selSysPwdByUserId(Long userId) {
        return null;
    }

    /**
     * 查出用户基本信息，用于修改
     * @param userId 用户ID
     * @return UserInfo
     */
    @Override
    public UserInfo selUserInfo(Long userId) {
        // 参数检查一下
        MemberUser memberUser;
        if (userId == null || (memberUser = memberUserMapper.selectByPrimaryKey(userId)) == null)
            return null;

        UserInfo info = new UserInfo();
        String portraitUrl = memberUser.getPortraitUrl();
        if (StringUtils.isNotEmpty(portraitUrl)) {
            if (portraitUrl.startsWith("/SGimg/"))
                portraitUrl = "//sgimage.571xz.com/new_image_site" + portraitUrl;
            info.setHeadUrl(portraitUrl);
        }
        info.setRealName(memberUser.getRealName());
        info.setUserNick(memberUser.getUserNick());
        info.setUserName(memberUser.getUserName());
        info.setEmail(memberUser.getEmail());
        info.setTelephone(memberUser.getPhoneMob());
        info.setSex(memberUser.getSex());
        info.setImQq(memberUser.getImQq());
        info.setImWx(memberUser.getImWeixin());
        info.setImWw(memberUser.getImAliww());
        return info;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateUserInfo(UserInfoUpdate userinfo) throws UpdateUserInfoException {
        MemberUser user = BeanMapper.map(userinfo, MemberUser.class);
        if (user.getUserId() == null)
            return 0;

        user.setPortraitUrl(userinfo.getHeadUrl());
        user.setImAliww(userinfo.getImWw());
        user.setImWeixin(userinfo.getImWx());
        // 1、增量更新表member_user
        int i = memberUserMapper.updateByPrimaryKeySelective(user);

        return i;
    }

    /**
     * 查询用户第三方绑定账户
     * @param userId 用户ID
     * @return
     */
    @Override
    public List<OuterUser> selOuterUsers(Long userId) {
        List<OuterUser> outerUserList = new ArrayList<OuterUser>();
        if(userId == null){
            return outerUserList;
        }
        MemberUserSubExample example = new MemberUserSubExample();
        example.createCriteria().andUserIdEqualTo(userId).andAccountTypeNotEqualTo(7);
        List<MemberUserSub> memberUserSubList = memberUserSubMapper.selectByExample(example);
        for(MemberUserSub memberUserSubdata : memberUserSubList){
            if(memberUserSubdata == null){
                continue;
            }
            OuterUser outerUser = new OuterUser();
            outerUser.setCreateTime(memberUserSubdata.getCreateTime());
            outerUser.setLoginFromType(LoginFromType.getLoginFromType(memberUserSubdata.getAccountType()));
            outerUser.setOuterNick(memberUserSubdata.getSubUserName());
            outerUser.setSubUserId(memberUserSubdata.getSubUserId());
            outerUserList.add(outerUser);
        }
        return outerUserList;
    }

    /**
     * 第三方账户解绑
     * @param userId 用户ID
     * @param subUserId 第三方子账户
     */
    @Override
    public void unBindUser(Long userId, Long subUserId) {
        MemberUserSub userSub;
        if(userId == null || subUserId == null || (userSub = memberUserSubMapper.selectByPrimaryKey(subUserId)) == null){
            return;
        }
        if (userSub.getAccountType() == LoginFromType.TAOBAO.getAccountType()) {
            ShiguShop shop = new ShiguShop();
            shop.setUserId(userId);
            shop.setShopStatus(0);
            shop = shiguShopMapper.selectOne(shop);
            if (shop != null) {
                shop.setUserId(null);
                shiguShopMapper.updateByPrimaryKey(shop);
            }
        }
        MemberUserSubExample subExample=new MemberUserSubExample();
        subExample.createCriteria().andSubUserIdEqualTo(subUserId).andUserIdEqualTo(userId);
        memberUserSubMapper.deleteByExample(subExample);
    }

    /**
     * 查询淘宝nick用户
     * @param tbNick
     * @return
     */
    @Override
    public Long selTbOuterUser(String tbNick) {
        if(StringUtils.isEmpty(tbNick)){
            return null;
        }
        MemberUserSubExample memberUserSubExample = new MemberUserSubExample();
        memberUserSubExample.createCriteria().andSubUserNameEqualTo(tbNick).
                andAccountTypeEqualTo(LoginFromType.TAOBAO.getAccountType());
        List<MemberUserSub> userSubList = memberUserSubMapper.selectByExample(memberUserSubExample);
        if(userSubList.size() == 0){
            return null;
        }
        MemberUserSub memberUserSubdata = userSubList.get(0);
        return memberUserSubdata.getUserId();
    }

    @Override
    public void setNewPayPwd(Long userId, String pwd) throws JsonErrException {
        if (StringUtils.isEmpty(pwd)) {
            throw new JsonErrException("支付密码不能为空");
        }
        MemberUser memberUser = memberUserMapper.selectFieldsByPrimaryKey(userId, FieldUtil.codeFields("user_id"));
        if (memberUser == null) {
            throw new JsonErrException("没有用户信息");
        }
        memberUser.setUserId(userId);
        memberUser.setPayPassword(EncryptUtil.encrypt(pwd));
        memberUser.setIsPayPassword(1);
        memberUserMapper.updateByPrimaryKeySelective(memberUser);
    }

    @Override
    public void changePayPwd(Long userId, String oldPwd, String newPwd) {

    }
}
