package com.shigu.phone.baseservices;

import com.openJar.beans.app.AppUser;
import com.openJar.exceptions.OpenException;
import com.openJar.responses.app.*;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.MemberLicenseExample;
import com.opentae.data.mall.interfaces.*;
import com.shigu.buyer.services.UserAccountService;
import com.shigu.component.shiro.CaptchaUsernamePasswordToken;
import com.shigu.component.shiro.enums.RoleEnum;
import com.shigu.component.shiro.enums.UserType;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.StringUtil;
import com.shigu.main4.tools.OssIO;
import com.shigu.main4.tools.RedisIO;
import com.shigu.main4.ucenter.enums.MemberLicenseType;
import com.shigu.main4.ucenter.exceptions.UpdateUserInfoException;
import com.shigu.main4.ucenter.services.RegisterAndLoginService;
import com.shigu.main4.ucenter.services.UserBaseService;
import com.shigu.main4.ucenter.services.UserLicenseService;
import com.shigu.main4.ucenter.util.EncryptUtil;
import com.shigu.main4.ucenter.vo.RegisterUser;
import com.shigu.main4.ucenter.vo.UserInfo;
import com.shigu.main4.ucenter.vo.UserInfoUpdate;
import com.shigu.phone.api.actions.PhoneMsgAction;
import com.shigu.phone.api.enums.ImgFormatEnum;
import com.shigu.phone.api.enums.PhoneMsgTypeEnum;
import com.shigu.phone.apps.services.PhoneUserService;
import com.shigu.phone.apps.utils.ImgUtils;
import com.shigu.phone.apps.utils.TokenUtil;
import com.shigu.phone.basebo.BindUserBO;
import com.shigu.phone.basevo.AboutMeVO;
import com.shigu.phone.basevo.BindUserVO;
import com.shigu.phone.basevo.CreatePostSignInfoVO;
import com.shigu.services.SendMsgService;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.Rds3TempUser;
import com.shigu.session.main4.ShopSession;
import com.shigu.session.main4.enums.LoginFromType;
import com.shigu.tools.RedomUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 类名：PhoneUserService
 * 类路径：com.shigu.phone.apps.baseservices.PhoneUserService
 * 创建者：王浩翔
 * 创建时间：2017-08-31 17:04
 * 项目：main-pom
 * 描述：移动端用户服务
 */
@Service
public class BasePhoneUserService {
    private static final Logger logger = LoggerFactory.getLogger(BasePhoneUserService.class);
    @Autowired
    private MemberLicenseMapper memberLicenseMapper;
    @Autowired
    private PhoneUserService phoneUserService;
    @Autowired
    SendMsgService sendMsgService;
    @Autowired
    private UserBaseService userBaseService;
    @Autowired
    private MemberUserMapper memberUserMapper;
    @Autowired
    private UserLicenseService userLicenseService;

    @Autowired
    private RegisterAndLoginService registerAndLoginService;

    @Autowired
    private UserAccountService userAccountService;

    @Autowired
    private PhoneMsgAction phoneMsgAction;

    @Autowired
    private RedisIO redisIO;

    @Autowired
    private OssIO ossIO;

    /**
     * 移动端我的信息
     *
     * @return
     */
    public AboutMeVO aboutMe(Long userId) {
        AboutMeVO aboutMeVO = new AboutMeVO();
        UserInfo userInfo = userBaseService.selUserInfo(userId);
        aboutMeVO.setUserNick(userInfo.getUserNick());
        aboutMeVO.setHeadUrl(ImgUtils.formatImg(userInfo.getHeadUrl(), ImgFormatEnum.HEAD));
        //获取用户绑定手机
        MemberLicense memberLicense = new MemberLicense();
        memberLicense.setUserId(userId);
        memberLicense.setLicenseType(MemberLicenseType.PHONE_BIND.getValue());
        memberLicense = memberLicenseMapper.selectOne(memberLicense);
        if (memberLicense != null) {
            aboutMeVO.setPhoneBind(memberLicense.getContext());
        }
        return aboutMeVO;
    }

    /**
     * 移动端登录
     */
    public AppUser login(String userName,String password,Integer phoneType,String remoteAddr) throws OpenException {
        OpenException openException = new OpenException();
        AppUser appUser = new AppUser();
        if (phoneType == 1) {
            //1普通账号密码登陆
            if (!StringUtil.isNull(userName) && !StringUtil.isNull(password)) {
                //用户名和密码不为空
                Subject currentUser = SecurityUtils.getSubject();
                CaptchaUsernamePasswordToken token = new CaptchaUsernamePasswordToken(
                        userName, password, false,remoteAddr, "", UserType.MEMBER);
                //星座用户登陆
                token.setLoginFromType(LoginFromType.XZ);
                token.setRememberMe(true);

                try {
                    //调用安全管理器,安全管理器调用realm
                    PersonalSession personalSession = getPersonalSession(userName, appUser, currentUser, token);
                    //查询是否绑定手机号
                    MemberLicenseExample memberLicenseExample = new MemberLicenseExample();
                    memberLicenseExample.createCriteria().andUserIdEqualTo(personalSession.getUserId()).andLicenseTypeEqualTo(4);
                    List<MemberLicense> memberLicensesList = memberLicenseMapper.selectByExample(memberLicenseExample);
                    //如果为空,说明用户没有绑定手机号,抛异常
                    if (memberLicensesList.size() == 0) {
                        openException.setErrMsg("未绑定手机号");
                        throw openException;
                    }
                } catch (AuthenticationException e) {
                    //登陆失败
                    token.clear();
                    openException.setErrMsg("用户名或密码错误");
                    throw openException;
                }
            }
        }
        if (phoneType == 2) {
            //2手机验证码登陆,UserName是手机号,password就是验证码
            if (!StringUtil.isNull(userName) && !StringUtil.isNull(password)) {
                //得到redis存的验证码
                String verify = redisIO.get("phone_login_type_msg_" + userName);
                if(StringUtil.isNull(verify)){
                    openException.setErrMsg("亲,您还没有发送验证码,请先发送验证码");
                    throw openException;
                }
                if (!verify.equals(password)) {
                    openException.setErrMsg("手机验证码错误");
                    throw openException;
                } else {
                    Subject currentUser = SecurityUtils.getSubject();
                    CaptchaUsernamePasswordToken token = new CaptchaUsernamePasswordToken(
                            userName, null, false, remoteAddr, "", UserType.MEMBER);
                    //星座用户登陆
                    token.setLoginFromType(LoginFromType.PHONE);
                    token.setRememberMe(true);
                    try {
                        PersonalSession personalSession = getPersonalSession(userName, appUser, currentUser, token);

                    } catch (AuthenticationException e) {
                        //登陆失败
                        token.clear();
                        openException.setErrMsg("手机号或验证码错误");
                        throw openException;
                    }
                }
             } else {
                //抛验证码错误
                openException.setErrMsg("手机号或验证码未输入");
                throw openException;
            }
        }
        appUser.setImgsrc(ImgUtils.formatImg(appUser.getImgsrc(), ImgFormatEnum.HEAD));
        return appUser;
    }
    //封装appUser参数
    private PersonalSession getPersonalSession( String userName, AppUser appUser, Subject currentUser, CaptchaUsernamePasswordToken token ) {
        currentUser.login(token);
        currentUser.hasRole(RoleEnum.STORE.getValue());
        //返回需要数据
        PersonalSession personalSession = userBaseService.selUserForSessionByUserName(userName, LoginFromType.XZ);

//                    appUser.setUserId(personalSession.getUserId());
        String headUrl = personalSession.getHeadUrl();
        appUser.setImgsrc(headUrl);
        appUser.setUserNick(personalSession.getUserNick());
        //token
        String phone_login_token = phoneUserService.createToken(personalSession.getUserId(), "phone_login_token");
        phone_login_token = TokenUtil.str2HexStr(phone_login_token);
        appUser.setToken(phone_login_token);
        //是否是商户
        if(SecurityUtils.getSubject().hasRole(RoleEnum.STORE.getValue())){
            appUser.setImSeller(true);
        }else{
            appUser.setImSeller(false);
        }
        return personalSession;
    }

    /**
     * 得到手机验证码
     */
    public String  getPhoneMsg(String telephone,Integer type) throws OpenException {
        OpenException openException=new OpenException();
        String code= RedomUtil.redomNumber(6);
        //发送短信
        sendMsgService.sendVerificationCode(telephone, code);
        //客户状态
        Jedis jedis = redisIO.getJedis();
        try {
            if (type == 1) {
                //登录
                jedis.setex("phone_login_type_msg_" + telephone, 600, code);
                //存入redis,保存10分钟
                return redisIO.get("phone_login_type_msg_" + telephone);
            } else if (type == 2) {
                //注册
                jedis.setex("phone_regist_type_msg_" + telephone, 600, code);
                return redisIO.get("phone_regist_type_msg_" + telephone);
            } else if (type == 3) {
                //忘记密码
                jedis.setex("phone_forget_type_msg_" + telephone, 600, code);
                return redisIO.get("phone_forget_type_msg_" + telephone);
            } else if (type == 4) {
                //绑定
                jedis.setex("phone_bind_type_msg_" + telephone, 600, code);
                return redisIO.get("phone_bind_type_msg_" + telephone);
            } else {
                openException.setErrMsg("客户状态错误");
                throw openException;
            }
        }finally {
            redisIO.returnJedis(jedis);
        }
    }

    /**
     * 移动端修改密码
     *
     * @return
     */
    public void changePassword( String oldPwd,String newPwd,Long userId) throws OpenException {
        OpenException openException=new OpenException();
        //用户验证不通过或原密码输入不正确
        if (!EncryptUtil.encrypt(oldPwd).equals(userBaseService.selUserPwdByUserId(userId))) {
            openException.setErrMsg("旧密码错误");
            throw openException;
        }
        try {
            userLicenseService.changePassword(userId, newPwd);
        } catch (Main4Exception e) {
            openException.setErrMsg("修改密码失败");
            throw openException;
        }
    }

    //忘记密码
    public void forgetPassword(String telephone,String msgCode,String newPassword ) throws OpenException {
        ForgetPasswordResponse resp=new ForgetPasswordResponse();
        OpenException openException = new OpenException();
        //从redis得到手机验证码
        String code=redisIO.get("phone_forget_type_msg_"+telephone);
        if (registerAndLoginService.selUserIdByName(telephone, LoginFromType.PHONE) == null) {
            openException.setErrMsg("该手机号还没有注册,请先去注册");
            throw openException;
        }

        if(code.equals(msgCode)){
            //验证成功,修改密码
            Long userId = registerAndLoginService.selUserIdByName(telephone, LoginFromType.PHONE);
            try {
                userLicenseService.changePassword(userId,newPassword);
                resp.setSuccess(true);
            } catch (Main4Exception e) {
                openException.setErrMsg("修改密码失败");
                throw openException;
            }
        }else {
            openException.setErrMsg("手机验证码不正确");
            throw openException;
        }
    }
    /**
     * 移动端用户注册
     * @return
     */
    public AppUser regist( String telephone,String code,String password) throws OpenException {
        OpenException openException = new OpenException();
        //PhoneVerify phoneMsg = phoneMsgAction.getPhoneMsg(request.getTelephone(), PhoneMsgTypeEnum.PHONE_REGIST_TYPE_MSG,PhoneVerify.class);
        String verifyCode = phoneMsgAction.getPhoneMsg(telephone, PhoneMsgTypeEnum.PHONE_REGIST_TYPE_MSG, String.class);
        //if (phoneMsg==null||!phoneMsg.getVerify().equals(request.getCode())|| !phoneMsg.getPhone().equals(request.getTelephone())) {
        if (verifyCode==null||!verifyCode.equals(code)) {
            openException.setErrMsg("手机验证码错误");
            throw openException;
        }
        RegisterUser registerUser=new RegisterUser();
        registerUser.setPassword(password);
        registerUser.setTelephone(telephone);
        try {
            if(registerAndLoginService.registerByPhone(registerUser)==null){
                openException.setErrMsg("用户已经存在");
                throw openException;
            }
        } catch (Main4Exception e) {
            openException.setErrMsg("注册失败");
            throw openException;
        }
        PersonalSession personalSession = userBaseService.selUserForSessionByUserName(telephone, LoginFromType.XZ);
        AppUser appUser=new AppUser();
//        appUser.setUserId(personalSession.getUserId());
        String headUrl = personalSession.getHeadUrl();
        appUser.setImgsrc(ImgUtils.formatImg(headUrl,ImgFormatEnum.HEAD));
        appUser.setUserNick(personalSession.getUserNick());
        //token
//        appUser.setToken(phoneUserService.createToken(personalSession.getUserId(),"phone_login_token"));


        //imSeller
        ShopSession logshop = personalSession.getLogshop();

        if (!StringUtil.isNull(logshop)) {
            appUser.setImSeller(true);
        } else {
            appUser.setImSeller(false);
        }
        return appUser;
    }

    /**
     * 移动端绑定手机
     * @return
     */
    public BindUserVO bindUser(BindUserBO bo) throws OpenException {
        BindUserVO bindUserVO = new BindUserVO();
        OpenException openException = new OpenException();
        Rds3TempUser rds3TempUser = new Rds3TempUser();
        rds3TempUser.setSubUserKey(bo.getTempId());
        rds3TempUser.setLoginFromType(LoginFromType.valueOf(bo.getType()));
        rds3TempUser.setSubUserName(bo.getUserNick());
        //Rds3TempUser rds3TempUser = phoneMsgAction.getPhoneMsg(request.getTempId(), PhoneMsgTypeEnum.PHONE_RDS3_TEMP_USER_TYPE_MSG, Rds3TempUser.class);
        if (!bo.getTempId().equals(rds3TempUser.getSubUserKey())) {
            openException.setErrMsg("账号或手机号错误");
            throw openException;
        }
        try {
            userAccountService.bindAccount(rds3TempUser,bo.getTelephone(),bo.getRemoteAddr());
        } catch (JsonErrException e) {
            openException.setErrMsg(e.getMessage());
            throw openException;
        }
        PersonalSession personalSession = userBaseService.selUserForSessionByUserName(rds3TempUser.getSubUserName(),rds3TempUser.getSubUserKey(), rds3TempUser.getLoginFromType());

        bindUserVO.setUserNick(personalSession.getUserNick());
        bindUserVO.setImgsrc(ImgUtils.formatImg(personalSession.getHeadUrl(),ImgFormatEnum.HEAD));
        boolean isSeller = personalSession.getLogshop() != null || (personalSession.getOtherShops() != null && personalSession.getOtherShops().size() > 0);
        bindUserVO.setImSeller(isSeller);
        //token

        bindUserVO.setToken(TokenUtil.str2HexStr(phoneUserService.createToken(personalSession.getUserId(),"phone_login_token")));
        return bindUserVO;
    }


    public void imgUpload(UserInfoUpdate userInfoUpdate) throws OpenException {
        try {
            //1 查出用户原头像地址
            UserInfo userInfo = userBaseService.selUserInfo(userInfoUpdate.getUserId());
            //2 移动新头像到正式目录
            String newHeadUrl = userInfoUpdate.getHeadUrl();
            if (!StringUtil.isNull(newHeadUrl)) {
                String moveHeadUrl = getImgOssPath(newHeadUrl);
                ossIO.moveFile(moveHeadUrl,moveHeadUrl.replace("tmp","mall/head"));
            }
            userInfoUpdate.setHeadUrl(newHeadUrl.replace("tmp","mall/head"));

            //3 删除原文件
            String oldHeadUrl = userInfo.getHeadUrl();
            if (!StringUtil.isNull(oldHeadUrl)) {
                oldHeadUrl = getImgOssPath(oldHeadUrl);
                if ( !StringUtil.isNull(oldHeadUrl)) {
                    ossIO.deleteFile(oldHeadUrl);
                }
            }

            userBaseService.updateUserInfo(userInfoUpdate);
        } catch (UpdateUserInfoException e) {
            OpenException openException = new OpenException();
            openException.setErrMsg("头像上传失败");
            throw openException;
        }
    }

    public UserInfo selUserInfo(Long userId){
        return userBaseService.selUserInfo(userId);
    }


    public AppUser msgCodeLogin( String userName,String password,String remoteAddr) throws OpenException {
        AppUser appUser = new AppUser();
        OpenException openException = new OpenException();
        //得到redis存的验证码
        String verify = redisIO.get("phone_login_type_msg_" + userName);
        if (StringUtil.isNull(verify)) {
            openException.setErrMsg("亲,您还没有发送验证码,请先发送验证码");
            throw openException;
        }
        if (!verify.equals(password)) {
            openException.setErrMsg("手机验证码错误");
            throw openException;
        } else {
            Subject currentUser = SecurityUtils.getSubject();
            CaptchaUsernamePasswordToken token = new CaptchaUsernamePasswordToken(
                    userName, null, false, remoteAddr, "", UserType.MEMBER);
            //星座用户登陆
            token.setLoginFromType(LoginFromType.PHONE);
            token.setRememberMe(true);
            try {
                currentUser.login(token);
                currentUser.hasRole(RoleEnum.STORE.getValue());
                //返回需要数据
                PersonalSession personalSession = userBaseService.selUserForSessionByUserName(userName, LoginFromType.XZ);

//                        appUser.setUserId(personalSession.getUserId());
                String headUrl = personalSession.getHeadUrl();
                appUser.setImgsrc(headUrl);
                appUser.setUserNick(personalSession.getUserNick());
                //是否是商户
                if (SecurityUtils.getSubject().hasRole(RoleEnum.STORE.getValue())) {
                    appUser.setImSeller(true);
                } else {
                    appUser.setImSeller(false);
                }
                return appUser;
            } catch (AuthenticationException e) {
                //登陆失败
                token.clear();
                openException.setErrMsg("手机号或验证码错误");
                throw openException;
            }
        }
    }

        /**
         * 获取 OSS 临时授权
         * @return
         */
    public CreatePostSignInfoVO createPostSignInfo() throws OpenException {
        CreatePostSignInfoVO createPostSignInfoVO = new CreatePostSignInfoVO();
        try {
            Map<String, String>postSignInfo = ossIO.createPostSignInfo("shigu/mall/file/");

            createPostSignInfoVO.setAccessid(postSignInfo.get("accessid"));
            createPostSignInfoVO.setPolicy(postSignInfo.get("policy"));
            createPostSignInfoVO.setSignature(postSignInfo.get("signature"));
            createPostSignInfoVO.setDir(postSignInfo.get("dir"));
            createPostSignInfoVO.setHost(postSignInfo.get("host"));
            createPostSignInfoVO.setExpire(postSignInfo.get("expire"));
            return createPostSignInfoVO;
        } catch (UnsupportedEncodingException e) {
            OpenException openException = new OpenException();
            openException.setErrMsg("获取临时授权失败");
            throw openException;
        }
    }

    /**
     * 是否需要绑定手机
     * @param userId
     */
    public boolean needBindTelephone(Long userId) {
        //查询是否绑定手机号
        MemberLicenseExample memberLicenseExample = new MemberLicenseExample();
        memberLicenseExample.createCriteria().andUserIdEqualTo(userId).andLicenseTypeEqualTo(4);
        List<MemberLicense> memberLicensesList = memberLicenseMapper.selectByExample(memberLicenseExample);
        //如果为空,说明用户没有绑定手机号
        if (memberLicensesList == null || memberLicensesList.isEmpty()) {
            return true;
        }else{
            return false;
        }
    }

    public void bindTelephone(Long userId, Long telephone,String msgCode) throws OpenException {
        if (!msgCode.equals(redisIO.get("phone_bind_type_msg_"+telephone))){
            OpenException openException = new OpenException();
            openException.setErrMsg("短信验证码错误");
            throw openException;
        }
        try {
            userLicenseService.bindPhone(userId,String.valueOf(telephone));
        } catch (Main4Exception e) {
            OpenException openException = new OpenException();
            openException.setErrMsg(e.getMessage());
            throw openException;
        }
    }

    public String getImgOssPath(String imgUrl){
        String reg = "(?<=http[s]?://)[^/]*";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(imgUrl);
        String group;
        if (matcher.find()){
            group = matcher.group();
        }else{
           return null;
        }
        int index = imgUrl.indexOf(group);
        return imgUrl.substring(index+group.length()+1);
    }
}
