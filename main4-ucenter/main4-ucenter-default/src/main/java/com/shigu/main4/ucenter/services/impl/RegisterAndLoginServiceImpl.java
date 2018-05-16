package com.shigu.main4.ucenter.services.impl;


import com.alibaba.fastjson.JSON;
import com.opentae.data.mall.beans.MemberUser;
import com.opentae.data.mall.beans.MemberUserSub;
import com.opentae.data.mall.beans.UidOutIdReference;
import com.opentae.data.mall.examples.MemberLicenseExample;
import com.opentae.data.mall.examples.MemberUserSubExample;
import com.opentae.data.mall.interfaces.*;
import com.searchtool.domain.SimpleElaBean;
import com.searchtool.mappers.ElasticRepository;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.tools.SpringBeanFactory;
import com.shigu.main4.ucenter.enums.MemberLicenseType;
import com.shigu.main4.ucenter.model.BindOuterRdUser;
import com.shigu.main4.ucenter.model.impl.BindJdUser;
import com.shigu.main4.ucenter.model.impl.BindTbUser;
import com.shigu.main4.ucenter.services.RegisterAndLoginService;
import com.shigu.main4.ucenter.services.UserLicenseService;
import com.shigu.main4.ucenter.util.EncryptUtil;
import com.shigu.main4.ucenter.vo.LoginRecord;
import com.shigu.main4.ucenter.vo.RegisterUser;
import com.shigu.session.main4.Rds3TempUser;
import com.shigu.session.main4.enums.LoginFromType;
import org.apache.zookeeper.Login;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 登陆与注册服务类
 *
 * @author shigu_zjb
 * @date 2017/02/21 16:47
 *
 */
@Service("registerAndLoginService")
public class RegisterAndLoginServiceImpl implements RegisterAndLoginService{

    private static final Logger logger = LoggerFactory.getLogger(RegisterAndLoginServiceImpl.class);

    @Resource(name = "tae_mall_memberUserMapper")
    private MemberUserMapper memberUserMapper;

    @Resource(name = "tae_mall_memberUserSubMapper")
    private MemberUserSubMapper memberUserSubMapper;

    @Resource(name = "tae_mall_memberLicenseMapper")
    private MemberLicenseMapper memberLicenseMapper;

    @Resource(name = "userLicenseService")
    private UserLicenseService userLicenseService;

    @Resource(name = "tae_mall_shiguShopMapper")
    private ShiguShopMapper shiguShopMapper;

    @Resource(name = "tae_mall_uidOutIdReferenceMapper")
    private UidOutIdReferenceMapper uidOutIdReferenceMapper;


    /**
     * 注册新用户
     * @param user
     * @return
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Long registerByPhone(RegisterUser user) throws Main4Exception {
        if(user == null || StringUtils.isEmpty(user.getTelephone()) ||
                StringUtils.isEmpty(user.getPassword())){
            return null;
        }
        boolean panss = userCanRegist(user.getTelephone() , LoginFromType.PHONE);
        if(!panss){
            logger.info("注册新用户>>失败>>Phone已经使用>>loginPhone:" + user.getTelephone());
            return null;
        }
        MemberUser memberUser = new MemberUser();
        memberUser.setUserNick(user.getTelephone());
        memberUser.setUserName(user.getTelephone());
        memberUser.setLoginPhone(user.getTelephone());
        memberUser.setRegTime(new Date());
        int result = memberUserMapper.insertSelective(memberUser);
        if(result == 0){
            logger.error("注册新用户>>失败>>执行插入数据库用户主表失败>>memberUser:" + JSON.toJSONString(memberUser));
            return null;
        }

        MemberUserSub memberUserSub = new MemberUserSub();
        memberUserSub.setSubUserName(user.getTelephone());
        memberUserSub.setUserId(memberUser.getUserId());

        String encryptPwd = EncryptUtil.encrypt(user.getPassword());

        memberUserSub.setSubUserPassword(encryptPwd);
        memberUserSub.setSubUserKey(UUID.randomUUID().toString().replace("-",""));
        memberUserSub.setAccountType(LoginFromType.PHONE.getAccountType());
        memberUserSub.setLogins(0L);
        memberUserSub.setUseStatus(1L);
        result = memberUserSubMapper.insertSelective(memberUserSub);
        if(result == 0){
            logger.error("注册新用户>>失败>>执行插入数据库用户子表失败>>memberUserSub:" + JSON.toJSONString(memberUserSub));
            throw new Main4Exception("注册新用户失败");
        }
        // 密码权益
        userLicenseService.passwordSafeCheck(memberUser.getUserId() ,user.getPassword());
        // 手机号权益
        userLicenseService.bindNotUserCanRegist(memberUser.getUserId(), user.getTelephone());

        //生成外部用户id
        UidOutIdReference uidOutIdReference = new UidOutIdReference();
        Date now = new Date();
        uidOutIdReference.setUid(memberUser.getUserId());
        uidOutIdReference.setGmtCreate(now);
        uidOutIdReference.setGmtModify(now);
        uidOutIdReferenceMapper.insertSelective(uidOutIdReference);

        return memberUser.getUserId();
    }

    /**
     * 根据用户id获取用户外部id
     * @param userId
     * @return
     */
    public Long selOutUidByUid(Long userId){
        if (userId == null) {
            return null;
        }
        UidOutIdReference uidOutIdReference = new UidOutIdReference();
        uidOutIdReference.setUid(userId);
        uidOutIdReference = uidOutIdReferenceMapper.selectOne(uidOutIdReference);
        if (uidOutIdReference == null) {
            return null;
        }
        return uidOutIdReference.getId();
    }

    /**
     * 手机号是否允许注册
     *
     * @return
     */
    @Override
    public boolean userCanRegist(String username, LoginFromType loginFromType) {
        return userCanRegist(username,null,loginFromType);
    }


    /**
     * 手机号是否允许注册
     *
     * @return
     */
    @Override
    public boolean userCanRegist(String username,String key, LoginFromType loginFromType) {
        if (StringUtils.isEmpty(username) || loginFromType == null) {
            return false;
        }
        if (loginFromType.getAccountType() == LoginFromType.PHONE.getAccountType()) {
            MemberUserSubExample memberUserSubExample = new MemberUserSubExample();
            memberUserSubExample.createCriteria().andSubUserNameEqualTo(username).
                    andAccountTypeEqualTo(LoginFromType.PHONE.getAccountType());
            int count = memberUserSubMapper.countByExample(memberUserSubExample);
            if (count > 0) {
                return false;
            }
            MemberLicenseExample memberLicenseExample = new MemberLicenseExample();
            memberLicenseExample.createCriteria().andContextEqualTo(username).
                    andLicenseTypeEqualTo(MemberLicenseType.PHONE_BIND.getValue()).andLicenseFailureEqualTo(1);
            count = memberLicenseMapper.countByExample(memberLicenseExample);
            if (count > 0) {
                return false;
            }
        } else if(loginFromType.getAccountType() == LoginFromType.WX.getAccountType()){//微信
            // 第三方
            MemberUserSubExample memberUserSubExample = new MemberUserSubExample();
            memberUserSubExample.createCriteria().andSubUserKeyEqualTo(key==null?"123321":key).
                    andAccountTypeEqualTo(loginFromType.getAccountType());
            int count = memberUserSubMapper.countByExample(memberUserSubExample);
            if (count > 0) {
                return false;
            }
        }else{
            // 第三方
            MemberUserSubExample memberUserSubExample = new MemberUserSubExample();
            memberUserSubExample.createCriteria().andSubUserNameEqualTo(username).
                    andAccountTypeEqualTo(loginFromType.getAccountType());
            int count = memberUserSubMapper.countByExample(memberUserSubExample);
            if (count > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 用户名反查用户ID
     * @param username
     * @param loginFromType
     * @return
     */
    @Override
    public Long selUserIdByName(String username, LoginFromType loginFromType) {
        MemberUserSubExample memberUserSubExample = new MemberUserSubExample();
        memberUserSubExample.createCriteria().andSubUserNameEqualTo(username)
                .andAccountTypeEqualTo(loginFromType.getAccountType());
        List<MemberUserSub> memberUserSubList = memberUserSubMapper.selectByExample(memberUserSubExample);
        if (memberUserSubList.size() == 0) {
            if(loginFromType.getAccountType() == LoginFromType.PHONE.getAccountType()){
                // 手机账号查询手机权益信息
                Long userId = userLicenseService.findUserIdByPhone(username);
                return userId;
            }
            return null;
        }
        return memberUserSubList.get(0).getUserId();
    }

    /**
     * 第三方账号绑定
     * @param phone 手机号
     * @param tempUser 第三方用户信息
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean bind3RdUser(String phone, Rds3TempUser tempUser) throws Main4Exception{
        if(StringUtils.isEmpty(phone) || tempUser == null || StringUtils.isEmpty(tempUser)
                || StringUtils.isEmpty(tempUser.getSubUserName())
                || tempUser.getLoginFromType() == null){
            return false;
        }
        boolean pans = userCanRegist(tempUser.getSubUserName(),tempUser.getSubUserKey(), tempUser.getLoginFromType());
        if (!pans) {
            throw new Main4Exception("该第三方账号已经绑定，不能重复绑定");
        }

        BindOuterRdUser bindOuterRdUser = null;
        switch (tempUser.getLoginFromType()) {
            case TAOBAO:
                bindOuterRdUser = SpringBeanFactory.getBean(BindTbUser.class);
                break;
            case JD:
                bindOuterRdUser = SpringBeanFactory.getBean(BindJdUser.class);
                break;
            case ALI:
                bindOuterRdUser = SpringBeanFactory.getBean(BindJdUser.class);
                break;
        }
        //检验是否准入
        if(bindOuterRdUser != null){
            bindOuterRdUser.admittance(phone, tempUser);
        }

        Long userId = selUserIdByName(phone, LoginFromType.PHONE);
        boolean existMember = false;
        int result = 0;

        if (userId == null) {
            // 主账号不存在 创建主账号
            RegisterUser registerUser = new RegisterUser();
            registerUser.setUserNick(tempUser.getSubUserName());
            registerUser.setTelephone(phone);
            String password = EncryptUtil.genRandomPwd(8);
            registerUser.setPassword(password);
            Long registerPanss = registerByPhone(registerUser);
            if (registerPanss == null) {
                return false;
            }
            userId = registerPanss;
        } else {
            // 标记已存在主账号信息
            existMember = true;
        }
        //判断一下,主账号下是否已经有这类型的账号
        MemberUserSubExample subExample=new MemberUserSubExample();
        subExample.createCriteria().andUserIdEqualTo(userId).andAccountTypeEqualTo(tempUser.getLoginFromType().getAccountType());
        if(memberUserSubMapper.countByExample(subExample)>0){
            throw new Main4Exception("该手机下已经绑定了["+tempUser.getLoginFromType().getTitle()+"]的账号,不能重复绑定同一类型的账号");
        }

        // 主账号已存在 判断子表数据
        MemberUserSub memberUserSub = new MemberUserSub();
        if (tempUser.getLoginFromType() == LoginFromType.WX) {
            memberUserSub.setSubUserKey(tempUser.getSubUserKey());
        }else{
            memberUserSub.setSubUserName(tempUser.getSubUserName());
        }
        memberUserSub.setAccountType(tempUser.getLoginFromType().getAccountType());
        result = memberUserSubMapper.selectCount(memberUserSub);
        if (result == 0) {
            // 子表数据不存在 绑定第三方数据
            if (tempUser.getLoginFromType() == LoginFromType.WX) {
                memberUserSub.setSubUserKey(tempUser.getSubUserKey());
            }else{
                memberUserSub.setSubUserName(tempUser.getSubUserName());
            }
            memberUserSub.setUserId(userId);
            memberUserSub.setSubUserKey(tempUser.getSubUserKey());
            memberUserSub.setAccountType(tempUser.getLoginFromType().getAccountType());
            memberUserSub.setLogins(0L);
            memberUserSub.setUseStatus(1L);
            result = memberUserSubMapper.insertSelective(memberUserSub);
            if (result == 0) {
                throw new Main4Exception("绑定第三方账号失败");
            }
        } else {
            // 存在子账号信息
            if (existMember) {
                logger.error("第三方账号绑定>>注册重复>>主账号/子账号都存在信息>>phone:" + phone + " tempUser:" + JSON.toJSONString(tempUser));
                return false;
            }
        }

        //绑定店铺信息
        if(bindOuterRdUser != null){
            bindOuterRdUser.bindShop(phone,tempUser,userId);
        }
        return true;
    }

    /**
     * 登录记录
     * @param loginRecord
     */
    @Override
    public void loginRecord(LoginRecord loginRecord) {
        if (loginRecord == null || loginRecord.getLoginFromType() == null || StringUtils.isEmpty(loginRecord.getIp()) ||
                StringUtils.isEmpty(loginRecord.getSubUserName()) || loginRecord.getSubUserId() == null ||
                loginRecord.getTime() == null || loginRecord.getUserId() == null) {
            logger.error("登录记录>>有空值数据>>data:" + JSON.toJSONString(loginRecord));
            return;
        }
        SimpleElaBean bean = new SimpleElaBean();
        bean.setIndex("login_record");
        bean.setType("log");
        bean.setSource(JSON.toJSONString(loginRecord));
        try {
            ElasticRepository elasticRepository = new ElasticRepository();
            elasticRepository.insert(bean);
        } catch (Exception e) {
            logger.error("登录记录>>异常>>添加新索引>>data:" + JSON.toJSONString(loginRecord) + " ERROR:" + e.toString());
            e.printStackTrace();
        }
    }
}
