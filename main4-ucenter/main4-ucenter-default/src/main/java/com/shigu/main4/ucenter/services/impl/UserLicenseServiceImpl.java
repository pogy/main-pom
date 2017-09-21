package com.shigu.main4.ucenter.services.impl;


import com.opentae.data.mall.beans.MemberLicense;
import com.opentae.data.mall.beans.MemberLicenseApply;
import com.opentae.data.mall.beans.MemberUser;
import com.opentae.data.mall.beans.MemberUserSub;
import com.opentae.data.mall.examples.MemberLicenseApplyExample;
import com.opentae.data.mall.examples.MemberLicenseExample;
import com.opentae.data.mall.examples.MemberUserSubExample;
import com.opentae.data.mall.interfaces.MemberLicenseApplyMapper;
import com.opentae.data.mall.interfaces.MemberLicenseMapper;
import com.opentae.data.mall.interfaces.MemberUserMapper;
import com.opentae.data.mall.interfaces.MemberUserSubMapper;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.ucenter.enums.MemberLicenseType;
import com.shigu.main4.ucenter.exceptions.MemberLicenseException;
import com.shigu.main4.ucenter.services.UserLicenseService;
import com.shigu.main4.ucenter.util.EncryptUtil;
import com.shigu.main4.ucenter.vo.RealNameApplyInfo;
import com.shigu.main4.ucenter.vo.SafeAbout;
import com.shigu.main4.ucenter.vo.UserLicense;
import com.shigu.session.main4.enums.LoginFromType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 用户权益类接口
 *
 * @author shigu_zjb
 * @date 2017/03/01 14:53
 *
 */
@Service("userLicenseService")
public class UserLicenseServiceImpl implements UserLicenseService {

    @Resource(name = "tae_mall_memberLicenseMapper")
    private MemberLicenseMapper memberLicenseMapper;

    @Resource(name = "tae_mall_memberUserMapper")
    private MemberUserMapper memberUserMapper;

    @Resource(name = "tae_mall_memberUserSubMapper")
    private MemberUserSubMapper memberUserSubMapper;

    @Resource(name = "tae_mall_memberLicenseApplyMapper")
    private MemberLicenseApplyMapper memberLicenseApplyMapper;

    @Override
    public Long selUserScore(Long userId) {
        if (userId != null) {
            MemberLicenseExample licenseExample = new MemberLicenseExample();
            licenseExample.createCriteria().andUserIdEqualTo(userId)
                    .andLicenseFailureEqualTo(1).andLicenseTypeEqualTo(MemberLicenseType.SCORE.getValue());
            List<MemberLicense> memberLicenses = memberLicenseMapper.selectByExample(licenseExample);
            if (!memberLicenses.isEmpty()) {
                String context = memberLicenses.get(0).getContext();
                if (StringUtils.isNotBlank(context))
                    try {
                        return Long.valueOf(context);
                    } catch (Exception ignored){}
            }
        }
        return 0L;
    }

    @Override
    public void addScore(Long userId, Integer addScore) throws MemberLicenseException {
        if (userId != null && addScore != null) {
            MemberLicense license = new MemberLicense();
            license.setUserId(userId);
            license.setLicenseType(MemberLicenseType.SCORE.getValue());
            license.setLicenseFailure(1);
            MemberLicense memberLicense = memberLicenseMapper.selectOne(license);
            if (memberLicense == null) {
                license.setContext(addScore.toString());
                memberLicenseMapper.insertSelective(license);
            } else {
                Integer oldScore = 0;
                try {
                    oldScore = Integer.valueOf(memberLicense.getContext());
                } catch (Exception ignored) {}
                Integer newScore = oldScore + addScore;
                if (newScore < 0)
                    throw new MemberLicenseException("积分不足");
                memberLicense.setContext(newScore.toString());
                memberLicenseMapper.updateByPrimaryKeySelective(memberLicense);
            }
        }
    }

    /**
     * 实名认证申请
     * @param userId
     * @param bdUrl
     */
    @Override
    public void realNameApply(Long userId, String bdUrl) throws Main4Exception {
        if(userId == null || StringUtils.isEmpty(bdUrl)){
            throw new Main4Exception("实名认证申请数据有误");
        }
        MemberLicenseApplyExample licenseApplyExample = new MemberLicenseApplyExample();
        licenseApplyExample.createCriteria().andLicenseTypeEqualTo(MemberLicenseType.REAL_NAME.getValue())
                .andUserIdEqualTo(userId).andApplyStatusEqualTo(0);
        int count = memberLicenseApplyMapper.countByExample(licenseApplyExample);
        if(count > 0){
            throw new Main4Exception("已提交实名认证申请，待审核");
        }
        MemberLicenseApply memberLicenseApply = new MemberLicenseApply();
        memberLicenseApply.setContext(bdUrl);
        memberLicenseApply.setLicenseType(MemberLicenseType.REAL_NAME.getValue());
        memberLicenseApply.setUserId(userId);
        memberLicenseApply.setApplyStatus(0);
        memberLicenseApply.setCreateTime(new Date());
        int result = memberLicenseApplyMapper.insertSelective(memberLicenseApply);
        if(result == 0){
            throw new Main4Exception("提交实名认证申请失败");
        }
    }

    /**
     * 实名认证审核
     * @param userId 用户ID
     * @param toExamine true表示通过,false表示不通过
     * @param reason 不通过原因
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void realName(Long userId, boolean toExamine, String reason) throws Main4Exception {
        MemberLicenseApply memberLicenseApply = new MemberLicenseApply();
        memberLicenseApply.setUserId(userId);
        memberLicenseApply.setApplyStatus(0);
        memberLicenseApply = memberLicenseApplyMapper.selectOne(memberLicenseApply);
        if(memberLicenseApply == null){
            throw new Main4Exception("未找到实名认证申请数据");
        }
        if (toExamine) {
            // 通过审核
            MemberLicense memberLicense = new MemberLicense();
            memberLicense.setContext(memberLicenseApply.getContext());
            memberLicense.setUserId(userId);
            memberLicense.setLicenseType(MemberLicenseType.REAL_NAME.getValue());
            memberLicense.setLicenseFailure(1);
            addUpdate(memberLicense);
            memberLicenseApply.setApplyStatus(1);
        } else {
            memberLicenseApply.setReason(reason);
            memberLicenseApply.setApplyStatus(-1);
        }
        memberLicenseApplyMapper.updateByPrimaryKeySelective(memberLicenseApply);
    }

    /**
     * 查最后一次实名认证的情况
     * @param userId
     * @return
     */
    @Override
    public RealNameApplyInfo lastRealNameApply(Long userId) {
        MemberLicenseApplyExample licenseApplyExample = new MemberLicenseApplyExample();
        licenseApplyExample.createCriteria().andLicenseTypeEqualTo(MemberLicenseType.REAL_NAME.getValue())
                .andUserIdEqualTo(userId);
        licenseApplyExample.setStartIndex(0);
        licenseApplyExample.setEndIndex(1);
        List<MemberLicenseApply> applies=memberLicenseApplyMapper.selectByConditionList(licenseApplyExample);
        if(applies.size()>0){
            MemberLicenseApply apply=applies.get(0);
            RealNameApplyInfo info=new RealNameApplyInfo();
            info.setApplyStatus(apply.getApplyStatus());
            info.setApplyTime(apply.getCreateTime());
            info.setReason(apply.getReason());
            return info;
        }
        return null;
    }

    /**
     * 密码安全分计算
     * @param userId 用户ID
     * @param password 密码原文
     * @return
     */
    @Override
    public int passwordSafeCheck(Long userId, String password) {
        if(userId == null || StringUtils.isEmpty(password)){
            return 0;
        }
        MemberUser memberUser = memberUserMapper.selectByPrimaryKey(userId);
        if(memberUser == null){
            return 0;
        }
        int passwordStrength = 0;
        if (password.matches(".*\\d.*")) {
            passwordStrength += 25;
        }
        if (password.matches(".*[a-z].*")) {
            passwordStrength += 25;
        }
        if (password.matches(".*[A-Z].*")) {
            passwordStrength += 25;
        }
        if (password.length() > 9) {
            passwordStrength += 25;
        }
        MemberLicense memberLicense = new MemberLicense();
        memberLicense.setLicenseType(MemberLicenseType.PASSWORD_SAFE.getValue());
        memberLicense.setUserId(userId);
        memberLicense.setContext(String.valueOf(passwordStrength));
        addUpdate(memberLicense);
        return passwordStrength;
    }

    /**
     * 新增>更新 用户权益
     * @param memberLicense
     */
    public void addUpdate(MemberLicense memberLicense){
        if(memberLicense == null){
            return;
        }
        MemberLicense dataMemberLicense = new MemberLicense();
        dataMemberLicense.setUserId(memberLicense.getUserId());
        dataMemberLicense.setLicenseType(memberLicense.getLicenseType());
        dataMemberLicense = memberLicenseMapper.selectOne(dataMemberLicense);
        if(dataMemberLicense != null){
            memberLicense.setUserLicenseId(dataMemberLicense.getUserLicenseId());
            memberLicenseMapper.updateByPrimaryKeySelective(memberLicense);
            return;
        }
        // 新增
        memberLicenseMapper.insertSelective(memberLicense);
    }


    private static final Pattern PHONE_NUMBER = Pattern.compile("1(3|4|5|7|8)[0-9]\\d{8}");

    /**
     * 绑定手机号
     * @param userId
     * @param phone
     * @throws Main4Exception
     */
    @Override
    public void bindPhone(Long userId, String phone) throws Main4Exception {
        if(userId == null || StringUtils.isEmpty(phone)){
            throw new Main4Exception("绑定手机号数据有误");
        }

        MemberUser memberUser = memberUserMapper.selectByPrimaryKey(userId);
        if (memberUser == null) {
            throw new Main4Exception("该用户不存在");
        }
        if (PHONE_NUMBER.matcher(memberUser.getUserName()).matches()
                && !phone.equals(memberUser.getUserName())) {
            memberUser.setUserName(phone);
            if (PHONE_NUMBER.matcher(memberUser.getUserNick()).matches()) {
                memberUser.setUserNick(phone);
            }
            memberUserMapper.updateByPrimaryKeySelective(memberUser);

            MemberUserSubExample subExample = new MemberUserSubExample();
            subExample.createCriteria().andUserIdEqualTo(userId)
                    .andAccountTypeEqualTo(LoginFromType.PHONE.getAccountType());

            MemberUserSub sub = new MemberUserSub();
            sub.setSubUserName(phone);
            memberUserSubMapper.updateByExampleSelective(sub, subExample);
        }

        MemberLicense memberLicense = new MemberLicense();
        memberLicense.setContext(phone);
        memberLicense.setUserId(userId);
        memberLicense.setLicenseType(MemberLicenseType.PHONE_BIND.getValue());
        memberLicense.setLicenseFailure(1);
        addUpdate(memberLicense);
    }

    /**
     * 绑定手机号 不判断准入
     * @param userId
     * @param phone
     * @throws Main4Exception
     */
    public void bindNotUserCanRegist(Long userId, String phone)throws Main4Exception{
        if(userId == null || StringUtils.isEmpty(phone)){
            throw new Main4Exception("绑定手机号数据有误");
        }
        MemberLicense memberLicense = new MemberLicense();
        memberLicense.setContext(phone);
        memberLicense.setUserId(userId);
        memberLicense.setLicenseType(MemberLicenseType.PHONE_BIND.getValue());
        memberLicense.setLicenseFailure(1);
        addUpdate(memberLicense);
    }

    /**
     * 绑定邮箱
     * @param userId
     * @param email
     */
    @Override
    public void bindEmail(Long userId, String email) throws Main4Exception {
        if(userId == null || StringUtils.isEmpty(email)){
            throw new Main4Exception("绑定邮箱数据有误");
        }
        MemberLicenseExample memberLicenseExample = new MemberLicenseExample();
        memberLicenseExample.createCriteria().andUserIdNotEqualTo(userId).
                andLicenseTypeEqualTo(MemberLicenseType.EMAIL.getValue()).andContextEqualTo(email);
        int result = memberLicenseMapper.countByExample(memberLicenseExample);
        if(result > 0){
            throw new Main4Exception("该邮箱已被使用");
        }
        MemberLicense memberLicense = new MemberLicense();
        memberLicense.setUserId(userId);
        memberLicense.setLicenseFailure(1);
        memberLicense.setLicenseType(MemberLicenseType.EMAIL.getValue());
        memberLicense.setContext(email);
        addUpdate(memberLicense);
    }

    /**
     * 查询用户权益
     * @param userId 用户ID
     * @return
     */
    @Override
    public SafeAbout selUserLicenses(Long userId) {
        if(userId == null){
            return null;
        }
        MemberUser memberUser = memberUserMapper.selectByPrimaryKey(userId);
        if(memberUser == null){
            return null;
        }
        MemberLicenseExample licenseExample = new MemberLicenseExample();
        licenseExample.createCriteria().andUserIdEqualTo(userId).andLicenseFailureEqualTo(1);
        List<MemberLicense> memberLicenseList = memberLicenseMapper.selectByExample(licenseExample);
        if(memberLicenseList.size() == 0){
            return null;
        }
        SafeAbout safeAbout = new SafeAbout();
        int score = 0;
        List<UserLicense> userLicenseList = new ArrayList<UserLicense>();
        for (int i = 0; i < memberLicenseList.size(); i++) {
            MemberLicense memberLicense = memberLicenseList.get(i);
            Integer licenseType = memberLicense.getLicenseType();
            switch (licenseType){
                case 1:
                    // 实名
                    score += 40;
                    break;
                case 2:
                    // 邮箱绑定
                    score += 10;
                    break;
                case 3:
                    // 密码安全
                    int passScore = Integer.valueOf(memberLicense.getContext());
                    if(passScore > 75){
                        score += 20;
                    }
                    break;
                case 4:
                    // 手机绑定
                    score += 30;
                    break;
            }
            UserLicense userLicense = new UserLicense();
            userLicense.setContext(memberLicense.getContext());
            userLicense.setType(MemberLicenseType.getMemberLicenseType(licenseType));
            userLicenseList.add(userLicense);
        }
        safeAbout.setScore(score);
        safeAbout.setLicenses(userLicenseList);
        return safeAbout;
    }

    /**
     * 修改密码
     * @param userId
     * @param password
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void changePassword(Long userId, String password) throws Main4Exception {
        if(userId == null || StringUtils.isEmpty(password)){
            throw new Main4Exception("修改密码数据有误");
        }
        MemberUser memberUser = memberUserMapper.selectByPrimaryKey(userId);
        if(memberUser == null){
            throw new Main4Exception("修改密码，找不到用户信息");
        }
        MemberUserSubExample userSubExample = new MemberUserSubExample();
//        userSubExample.createCriteria().andUserIdEqualTo(userId).andAccountTypeEqualTo(memberUser.getAccountType());
        //只能修改星座账号
        userSubExample.createCriteria().andUserIdEqualTo(userId).andAccountTypeEqualTo(LoginFromType.XZ.getAccountType());
        List<MemberUserSub> memberUserSubList = memberUserSubMapper.selectByExample(userSubExample);
        if(memberUserSubList.size() == 0){
            throw new Main4Exception("修改密码，找不到子用户信息");
        }
        MemberUserSub memberUserSub = memberUserSubList.get(0);
        String encryptPwd = EncryptUtil.encrypt(password);
        memberUserSub.setSubUserPassword(encryptPwd);
        memberUserSubMapper.updateByPrimaryKeySelective(memberUserSub);
        passwordSafeCheck(userId, password);
    }

    /**
     * 根据手机号查询权益userId
     * @param phone
     * @return
     */
    @Override
    public Long findUserIdByPhone(String phone) {
        if(StringUtils.isEmpty(phone)){
            return null;
        }
        MemberLicense memberLicense = new MemberLicense();
        memberLicense.setContext(phone);
        memberLicense.setLicenseType(MemberLicenseType.PHONE_BIND.getValue());
        memberLicense.setLicenseFailure(1);
        memberLicense = memberLicenseMapper.selectOne(memberLicense);
        if(memberLicense == null){
            return null;
        }
        return memberLicense.getUserId();
    }

    /**
     * 根据userId查询权益手机号
     * @param userId
     * @return
     */
    @Override
    public String findPhoneByUserId(Long userId) {
        if(userId == null){
            return null;
        }
        MemberLicense memberLicense = new MemberLicense();
        memberLicense.setUserId(userId);
        memberLicense.setLicenseType(MemberLicenseType.PHONE_BIND.getValue());
        memberLicense.setLicenseFailure(1);
        memberLicense = memberLicenseMapper.selectOne(memberLicense);
        if(memberLicense == null){
            return null;
        }
        return memberLicense.getContext();
    }


}
