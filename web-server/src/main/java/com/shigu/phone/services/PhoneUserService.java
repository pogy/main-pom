package com.shigu.phone.services;

import com.openJar.beans.app.AppUser;
import com.openJar.exceptions.OpenException;
import com.openJar.requests.Request;
import com.openJar.requests.app.*;
import com.openJar.responses.app.*;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.MemberLicenseExample;
import com.opentae.data.mall.examples.MemberUserSubExample;
import com.opentae.data.mall.examples.ShiguShopExample;
import com.opentae.data.mall.examples.TaobaoSessionMapExample;
import com.opentae.data.mall.interfaces.*;
import com.shigu.buyer.services.UserAccountService;
import com.shigu.component.shiro.CaptchaUsernamePasswordToken;
import com.shigu.component.shiro.enums.RoleEnum;
import com.shigu.component.shiro.enums.UserType;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.StringUtil;
import com.shigu.main4.common.util.UUIDGenerator;
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
import com.shigu.phone.api.enums.PhoneMsgTypeEnum;
import com.shigu.phone.apps.utils.TokenUtil;
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

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 类名：PhoneUserService
 * 类路径：com.shigu.phone.services.PhoneUserService
 * 创建者：王浩翔
 * 创建时间：2017-08-31 17:04
 * 项目：main-pom
 * 描述：移动端用户服务
 */
@Service
public class PhoneUserService {
    private static final Logger logger = LoggerFactory.getLogger(PhoneUserService.class);
    @Autowired
    private MemberLicenseMapper memberLicenseMapper;
    @Autowired
    SendMsgService sendMsgService;
    @Autowired
    private UserBaseService userBaseService;
    @Autowired
    private MemberUserMapper memberUserMapper;
    @Autowired
    private TaobaoSessionMapMapper taobaoSessionMapMapper;
    @Autowired
    private ShiguShopMapper shiguShopMapper;
    @Resource(name = "tae_mall_memberUserSubMapper")
    private MemberUserSubMapper memberUserSubMapper;

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
     * @param request
     * @return
     */
    public AboutMeResponse aboutMe( AboutMeRequest request) {
        AboutMeResponse resp = new AboutMeResponse();
        UserInfo userInfo = userBaseService.selUserInfo(request.getUserId());
        resp.setUserNick(userInfo.getUserNick());
        resp.setHeadUrl(userInfo.getHeadUrl());
        //获取用户绑定手机
        MemberLicense memberLicense = new MemberLicense();
        memberLicense.setUserId(request.getUserId());
        memberLicense.setLicenseType(MemberLicenseType.PHONE_BIND.getValue());
        memberLicense = memberLicenseMapper.selectOne(memberLicense);
        if (memberLicense != null) {
            resp.setPhoneBind(memberLicense.getContext());
        }
        resp.setSuccess(true);
        return resp;
    }

    /**
     * 移动端登录
     */
    public LoginResponse login( LoginRequest request, HttpServletRequest servletRequest) {
        LoginResponse resp = new LoginResponse();
        Integer phoneType = request.getType();
        OpenException openException = new OpenException();
        AppUser appUser = new AppUser();
        if (phoneType == 1) {
            //1普通账号密码登陆
            if (!StringUtil.isNull(request.getUserName()) && !StringUtil.isNull(request.getPassword())) {
                //用户名和密码不为空
                Subject currentUser = SecurityUtils.getSubject();
                CaptchaUsernamePasswordToken token = new CaptchaUsernamePasswordToken(
                        request.getUserName(), request.getPassword(), false, servletRequest.getRemoteAddr(), "", UserType.MEMBER);
                //星座用户登陆
                token.setLoginFromType(LoginFromType.XZ);
                token.setRememberMe(true);

                try {
                    //调用安全管理器,安全管理器调用realm
                    currentUser.login(token);
                    currentUser.hasRole(RoleEnum.STORE.getValue());
                    //返回需要数据
                    PersonalSession personalSession = userBaseService.selUserForSessionByUserName(request.getUserName(), LoginFromType.XZ);

//                    appUser.setUserId(personalSession.getUserId());
                    String headUrl = personalSession.getHeadUrl();
                    appUser.setImgsrc(headUrl);
                    appUser.setUserNick(personalSession.getUserNick());
//                    String uuid = UUIDGenerator.getUUID();
                    String uuid= TokenUtil.format(personalSession.getUserId());
                    String inRedisToken= uuid+"@@@@@---@@@@@"+new Date().getTime();
                    //把token存入redis,设置存活时间30分钟
                    // redisIO.putFixedTemp("phone_login_token",uuid,1800);会提前转译一次json,
                    Jedis jedis = redisIO.getJedis();
                    jedis.setex("phone_login_token" + personalSession.getUserId(), 1800, inRedisToken);
                    appUser.setToken(uuid);
                    //是否是商家
                    ShiguShopExample shiguShopExample=new ShiguShopExample();
                    shiguShopExample.createCriteria().andUserIdEqualTo(personalSession.getUserId());
                    List<ShiguShop> shiguShops = shiguShopMapper.selectByExample(shiguShopExample);
                    if(shiguShops.size()>0){
                        ShiguShop shiguShop = shiguShops.get(0);
                        Integer shopStatus = shiguShop.getShopStatus();//0是卖家,1不是卖家
                        if(shopStatus==0){
                            appUser.setImSeller(true);
                        }else{
                            appUser.setImSeller(false);
                        }
                    }else{
                        appUser.setImSeller(false);
                    }
                    resp.setUsers(appUser);
                    //查询是否绑定手机号
                    MemberLicenseExample memberLicenseExample = new MemberLicenseExample();
                    memberLicenseExample.createCriteria().andUserIdEqualTo(personalSession.getUserId()).andLicenseTypeEqualTo(4);
                    List<MemberLicense> memberLicensesList = memberLicenseMapper.selectByExample(memberLicenseExample);
                    //如果为空,说明用户没有绑定手机号,抛异常
                    if (memberLicensesList.size() == 0) {
                        openException.setErrMsg("未绑定手机号");
                        resp.setException(openException);
                        resp.setSuccess(false);
                        return resp;
                    }
                    resp.setSuccess(true);
                    return resp;
                } catch (AuthenticationException e) {
                    //登陆失败
                    token.clear();
                    openException.setErrMsg("用户名或密码错误");
                    resp.setException(openException);
                    resp.setSuccess(false);
                    return resp;
                }
            }
        }
        if (phoneType == 2) {
            //2手机验证码登陆,UserName是手机号,password就是验证码
            if (!StringUtil.isNull(request.getUserName()) && !StringUtil.isNull(request.getPassword())) {
                //得到redis存的验证码
                String verify = redisIO.get("phone_login_type_msg_" + request.getUserName());
                if(StringUtil.isNull(verify)){
                    openException.setErrMsg("亲,您还没有发送验证码,请先发送验证码");
                    resp.setException(openException);
                    resp.setSuccess(false);
                    return resp;
                }
                if (!verify.equals(request.getPassword())) {
                    openException.setErrMsg("手机验证码错误");
                    resp.setException(openException);
                    resp.setSuccess(false);
                    return resp;
                } else {
                    Subject currentUser = SecurityUtils.getSubject();
                    CaptchaUsernamePasswordToken token = new CaptchaUsernamePasswordToken(
                            request.getUserName(), null, false, servletRequest.getRemoteAddr(), "", UserType.MEMBER);
                    //星座用户登陆
                    token.setLoginFromType(LoginFromType.PHONE);
                    token.setRememberMe(true);
                    try {
                        currentUser.login(token);
                        currentUser.hasRole(RoleEnum.STORE.getValue());
                        //返回需要数据
                        PersonalSession personalSession = userBaseService.selUserForSessionByUserName(request.getUserName(), LoginFromType.XZ);

//                        appUser.setUserId(personalSession.getUserId());
                        String headUrl = personalSession.getHeadUrl();
                        appUser.setImgsrc(headUrl);
                        appUser.setUserNick(personalSession.getUserNick());
                        String uuid = UUIDGenerator.getUUID();
                        //把token存入redis,设置存活时间30分钟
                        // redisIO.putFixedTemp("phone_login_token",uuid,1800);会提前转译一次json,
                        Jedis jedis = redisIO.getJedis();
                        jedis.setex("phone_login_token" + personalSession.getUserId(), 1800, uuid);
                        //从redis取出token
                        String token1 = redisIO.get("phone_login_token" + personalSession.getUserId());
                        appUser.setToken(token1);
                        //是否是商户
                        ShiguShopExample shiguShopExample=new ShiguShopExample();
                        shiguShopExample.createCriteria().andUserIdEqualTo(personalSession.getUserId());
                        List<ShiguShop> shiguShops = shiguShopMapper.selectByExample(shiguShopExample);
                        if(shiguShops.size()>0){
                            ShiguShop shiguShop = shiguShops.get(0);
                            Integer shopStatus = shiguShop.getShopStatus();//0是卖家,1不是卖家
                            if(shopStatus==0){
                                appUser.setImSeller(true);
                            }else{
                                appUser.setImSeller(false);
                            }
                        }else{
                            appUser.setImSeller(false);
                        }
                        resp.setUsers(appUser);
                        resp.setSuccess(true);
                        return resp;
                    } catch (AuthenticationException e) {
                        //登陆失败
                        token.clear();
                        openException.setErrMsg("手机号或验证码错误");
                        resp.setException(openException);
                        resp.setSuccess(false);
                        return resp;
                    }
                }
            } else {
                //抛验证码错误
                openException.setErrMsg("手机号或验证码未输入");
                resp.setException(openException);
                resp.setSuccess(false);
                return resp;
            }
        }

        return resp;
    }

    //第三方登录
    public Object ortherLogin( OrtherLoginRequest request ) {
        OrtherLoginResponse resp=new OrtherLoginResponse();
        OpenException openException=new OpenException();
        AppUser appUser=new AppUser();
        if(request.getType()==1){
            //1:淘宝
            if(StringUtil.isNull(request.getNick())){
                openException.setErrMsg("淘宝登录,缺少nick参数");
                resp.setException(openException);
                resp.setSuccess(false);
            }else {
               //传入参数完整
                MemberUserSubExample memberUserSubExample=new MemberUserSubExample();
                memberUserSubExample.createCriteria().andAccountTypeEqualTo(3).andSubUserNameEqualTo(request.getNick());
                List<MemberUserSub> memberUserSubs = memberUserSubMapper.selectByExample(memberUserSubExample);
                if(memberUserSubs.size()>0){
                    //用户附表有用户数据
                    MemberUserSub mus=memberUserSubs.get(0);
                    MemberUser memberUser=memberUserMapper.selectFieldsByPrimaryKey(mus.getUserId(),
                            FieldUtil.codeFields("user_id,user_nick,portrait_url"));
                    if(memberUser==null){//数据异常
                        logger.error(mus.getUserId()+"此用户,分表里有,主表里不存在!!!!!!!");
                        return null;
                    }
//                    appUser.setUserId(memberUser.getUserId());
                    //用户头像封装
                    String url = memberUser.getPortraitUrl();
                    if(url != null && url.startsWith("/SGimg/")){
                        url="//sgimage.571xz.com/new_image_site"+url;
                    }
                    appUser.setImgsrc(url);
                    //是否是商户
                    ShiguShopExample shiguShopExample=new ShiguShopExample();
                    shiguShopExample.createCriteria().andUserIdEqualTo(memberUser.getUserId());
                    List<ShiguShop> shiguShops = shiguShopMapper.selectByExample(shiguShopExample);
                    if(shiguShops.size()>0){
                        ShiguShop shiguShop = shiguShops.get(0);
                        Integer shopStatus = shiguShop.getShopStatus();//0是卖家,1不是卖家
                        if(shopStatus==0){
                            appUser.setImSeller(true);
                        }else{
                            appUser.setImSeller(false);
                        }
                    }else{
                        appUser.setImSeller(false);
                    }

                    String uuid = UUIDGenerator.getUUID();
                    //把token存入redis,设置存活时间30分钟
                    // redisIO.putFixedTemp("phone_login_token",uuid,1800);会提前转译一次json,
                    Jedis jedis = redisIO.getJedis();
                    jedis.setex("phone_login_token" + memberUser.getUserId(), 1800, uuid);
                    //从redis取出token
                    String token1 = redisIO.get("phone_login_token" + memberUser.getUserId());
                    appUser.setToken(token1);
                    appUser.setUserNick(memberUser.getUserNick());
                    resp.setType(1);
                    resp.setUsers(appUser);
                }else{
                    //没有绑定星座网
                    openException.setErrMsg("亲,您还没有绑定星座网,请先去绑定");
                    resp.setException(openException);
                    resp.setType(0);
                    //根据昵称查询唯一键
                    TaobaoSessionMapExample taobaoSessionMapExample=new TaobaoSessionMapExample();
                    taobaoSessionMapExample.createCriteria().andNickEqualTo(request.getNick());
                    List<TaobaoSessionMap> taobaoSessionMaps = taobaoSessionMapMapper.selectByExample(taobaoSessionMapExample);
                    if(taobaoSessionMaps.size()>0){
                        resp.setTempId(taobaoSessionMaps.get(0).getUserId()+"");
                    }

                }
            }
        }else if(request.getType()==2){
            //2:微信
            if(StringUtil.isNull(request.getKey())){
                openException.setErrMsg("淘宝登录,缺少key参数");
                resp.setException(openException);
                resp.setSuccess(false);
            }else{
                //传入参数完整

            }
        }else{
            openException.setErrMsg("传入类型不对");
            resp.setException(openException);
            resp.setSuccess(false);
        }
        resp.setSuccess(true);
        return resp;
    }
    /**
     * 得到手机验证码
     */
    public GetPhoneMsgResponse getPhoneMsg(GetPhoneMsgRequest request){
        GetPhoneMsgResponse resp=new GetPhoneMsgResponse();
        OpenException openException=new OpenException();
        String code= RedomUtil.redomNumber(6);
        //发送短信
        sendMsgService.sendVerificationCode(request.getTelephone(), code);
        //客户状态
        Integer type = request.getType();
        if(type==1){
            //登录
            Jedis jedis = redisIO.getJedis();
            jedis.setex("phone_login_type_msg_"+request.getTelephone(),600, code);
            //存入redis,保存10分钟
            resp.setMsgCode(redisIO.get("phone_login_type_msg_"+request.getTelephone()));
            resp.setSuccess(true);
        }else if(type==2){
            //注册
            Jedis jedis = redisIO.getJedis();
            jedis.setex("phone_regist_type_msg_"+request.getTelephone(),600, code);
            resp.setMsgCode(redisIO.get("phone_regist_type_msg_"+request.getTelephone()));
            resp.setSuccess(true);
        }else if(type==3){
            //忘记密码
            Jedis jedis = redisIO.getJedis();
            jedis.setex("phone_forget_type_msg_"+request.getTelephone(),600, code);
            resp.setMsgCode(redisIO.get("phone_forget_type_msg_"+request.getTelephone()));
            resp.setSuccess(true);
        }else if(type==4){
            //绑定
            Jedis jedis = redisIO.getJedis();
            jedis.setex("phone_bind_type_msg_"+request.getTelephone(),600, code);
            resp.setMsgCode(redisIO.get("phone_bind_type_msg_"+request.getTelephone()));
            resp.setSuccess(true);
        }else{
            openException.setErrMsg("客户状态错误");
            resp.setException(openException);
            resp.setSuccess(false);
        }

        return resp;
    }

    /**
     * 移动端修改密码
     *
     * @param request
     * @return
     */
    public ChangePasswordResponse changePassword( ChangePasswordRequest request) {
        ChangePasswordResponse resp = new ChangePasswordResponse();
        OpenException openException=new OpenException();
        if (StringUtil.isNull(redisIO.get("phone_login_token"+request.getUserId()))||StringUtil.isNull(request.getToken())){
            openException.setErrMsg("亲,您还未登录,请先登录");
            resp.setException(openException);
            resp.setSuccess(false);
            return resp;
        }
        if(!redisIO.get("phone_login_token"+request.getUserId()).equals(request.getToken())){
            openException.setErrMsg("登录信息被篡改");
            resp.setException(openException);
            resp.setSuccess(false);
            return resp;
        }
        //用户验证不通过或原密码输入不正确
        if (!EncryptUtil.encrypt(request.getOldPwd()).equals(userBaseService.selUserPwdByUserId(request.getUserId()))) {
            openException.setErrMsg("老密码错误");
            resp.setException(openException);
            resp.setSuccess(false);
            return resp;
        }

        try {
            userLicenseService.changePassword(request.getUserId(), request.getNewPwd());
            resp.setSuccess(true);
        } catch (Main4Exception e) {
            openException.setErrMsg("修改密码失败");
            resp.setException(openException);
        }
        return resp;
    }
    //忘记密码
    public ForgetPasswordResponse forgetPassword( ForgetPasswordRequest request ) {
        ForgetPasswordResponse resp=new ForgetPasswordResponse();
        OpenException openException = new OpenException();
        //从redis得到手机验证码
        String code=redisIO.get("phone_forget_type_msg_"+request.getTelephone());
        if (registerAndLoginService.selUserIdByName(request.getTelephone(), LoginFromType.PHONE) == null) {
            openException.setErrMsg("该手机号还没有注册,请先去注册");
            resp.setException(openException);
            resp.setSuccess(false);
            return resp;
        }

        if(code.equals(request.getMsgCode())){
            //验证成功,修改密码
            Long userId = registerAndLoginService.selUserIdByName(request.getTelephone(), LoginFromType.PHONE);
            try {
                userLicenseService.changePassword(userId, request.getNewPassword());
                resp.setSuccess(true);
            } catch (Main4Exception e) {
                openException.setErrMsg("修改密码失败");
                resp.setException(openException);
                return resp;
            }

        }else {
            openException.setErrMsg("手机验证码不正确");
            resp.setException(openException);
            resp.setSuccess(false);
        }
        return resp;
    }
    /**
     * 移动端用户注册
     * @param request
     * @return
     */
    public RegistResponse regist( RegistRequest request){
        RegistResponse resp = new RegistResponse();
        //PhoneVerify phoneMsg = phoneMsgAction.getPhoneMsg(request.getTelephone(), PhoneMsgTypeEnum.PHONE_REGIST_TYPE_MSG,PhoneVerify.class);
        String verifyCode = phoneMsgAction.getPhoneMsg(request.getTelephone(), PhoneMsgTypeEnum.PHONE_REGIST_TYPE_MSG, String.class);
        //if (phoneMsg==null||!phoneMsg.getVerify().equals(request.getCode())|| !phoneMsg.getPhone().equals(request.getTelephone())) {
        if (verifyCode==null||!verifyCode.equals(request.getCode())) {
            OpenException openException = new OpenException();
            openException.setErrMsg("手机验证码错误");
            resp.setException(openException);
            resp.setSuccess(false);
            return resp;
        }
        RegisterUser registerUser=new RegisterUser();
        registerUser.setPassword(request.getPassword());
        registerUser.setTelephone(request.getTelephone());
        try {
            if(registerAndLoginService.registerByPhone(registerUser)==null){
                OpenException openException = new OpenException();
                openException.setErrMsg("用户已经存在");
                resp.setException(openException);
                resp.setSuccess(false);
                return resp;
            }
        } catch (Main4Exception e) {
            resp.setException(new OpenException());
            resp.setSuccess(false);
            return resp;
        }
        PersonalSession personalSession = userBaseService.selUserForSessionByUserName(request.getTelephone(), LoginFromType.XZ);
        AppUser appUser=new AppUser();
//        appUser.setUserId(personalSession.getUserId());
        String headUrl = personalSession.getHeadUrl();
        appUser.setImgsrc(headUrl);
        appUser.setUserNick(personalSession.getUserNick());
        String uuid = UUIDGenerator.getUUID();
        //把token存入redis,设置存活时间30分钟
        // redisIO.putFixedTemp("phone_login_token",uuid,1800);会提前转译一次json,
        Jedis jedis = redisIO.getJedis();
        jedis.setex("phone_login_token" + personalSession.getUserId(), 1800, uuid);
        //从redis取出token
        String token1 = redisIO.get("phone_login_token" + personalSession.getUserId());
        appUser.setToken(token1);
        //imSeller
        ShopSession logshop = personalSession.getLogshop();

        if (!StringUtil.isNull(logshop)) {
            appUser.setImSeller(true);
        } else {
            appUser.setImSeller(false);
        }
        resp.setUsers(appUser);
        resp.setSuccess(true);
        return resp;
    }

    /**
     * 移动端绑定手机
     * @param request
     * @return
     */
    public BindUserResponse bindUser( BindUserRequest request, String remoteAddr){
        BindUserResponse resp = new BindUserResponse();
        //PhoneVerify phoneMsg = phoneMsgAction.getPhoneMsg(request.getTelephone(), PhoneMsgTypeEnum.PHONE_BIND_TYPE_MSG,PhoneVerify.class);
//        String phoneMsg = phoneMsgAction.getPhoneMsg(request.getTelephone(), PhoneMsgTypeEnum.PHONE_BIND_TYPE_MSG,String.class);
//
//        if (phoneMsg==null||!phoneMsg.equals(request.getCode())) {
//            OpenException openException = new OpenException();
//            openException.setErrMsg("验证码错误");
//            resp.setException(openException);
//            resp.setSuccess(false);
//            return resp;
//        }
        Rds3TempUser rds3TempUser = new Rds3TempUser();
        rds3TempUser.setSubUserKey(request.getTempId());
        rds3TempUser.setLoginFromType(LoginFromType.valueOf(request.getType()));
        rds3TempUser.setSubUserName(request.getUserNick());
        //Rds3TempUser rds3TempUser = phoneMsgAction.getPhoneMsg(request.getTempId(), PhoneMsgTypeEnum.PHONE_RDS3_TEMP_USER_TYPE_MSG, Rds3TempUser.class);
        if (!request.getTempId().equals(rds3TempUser.getSubUserKey())) {
            OpenException openException = new OpenException();
            openException.setErrMsg("账号或手机号错误");
            resp.setException(openException);
            resp.setSuccess(false);
            return resp;
        }
        try {
            userAccountService.bindAccount(rds3TempUser,request.getTelephone(),remoteAddr);
        } catch (JsonErrException e) {
            resp.setException(new OpenException());
            resp.setSuccess(false);
            return resp;
        }
        PersonalSession personalSession = userBaseService.selUserForSessionByUserName(rds3TempUser.getSubUserName(), rds3TempUser.getLoginFromType());
        resp.setUserId(personalSession.getUserId());
        resp.setUserNick(personalSession.getUserNick());
        resp.setImgsrc(personalSession.getHeadUrl());
        boolean isSeller = personalSession.getLogshop() != null || (personalSession.getOtherShops() != null && personalSession.getOtherShops().size() > 0);
        resp.setImSeller(isSeller);
        String token = EncryptUtil.genRandomPwd(36);
        //todo:之后使用的是tempID还是登陆唯一标志需要确认，token保存时长暂时用1小时，保存用户信息
        redisIO.putTemp(PhoneMsgTypeEnum.PHONE_USER_INFO.getType()+personalSession.getUserId()+"_"+token,personalSession,3600*1);
        resp.setToken(token);
        resp.setSuccess(true);
        return resp;
    }


    public ImgUploadResponse imgUpload(ImgUploadRequest request){
//        System.err.println(userBaseService.selUserInfo(request.getUserId()).getHeadUrl());
        ImgUploadResponse response = new ImgUploadResponse();
        try {
            UserInfoUpdate userInfoUpdate = new UserInfoUpdate();
            userInfoUpdate.setUserId(request.getUserId());
            userInfoUpdate.setHeadUrl(request.getFile());
            userBaseService.updateUserInfo(userInfoUpdate);
        } catch (UpdateUserInfoException e) {
//            e.printStackTrace();
            OpenException openException = new OpenException();
            openException.setErrMsg("头像上传失败");
            response.setException(openException);
            response.setSuccess(false);
            return response;
        }
        response.setSuccess(true);
        return response;
    }

    /**
     * 获取 OSS 临时授权
     * @return
     */
    public CreatePostSignInfoResponse createPostSignInfo(){
        CreatePostSignInfoResponse response = new CreatePostSignInfoResponse();
        Map<String, String> postSignInfo = null;
        try {
            postSignInfo = ossIO.createPostSignInfo("shigu/mall/file/");

            response.setAccessid(postSignInfo.get("accessid"));
            response.setPolicy(postSignInfo.get("policy"));
            response.setSignature(postSignInfo.get("signature"));
            response.setDir(postSignInfo.get("dir"));
            response.setHost(postSignInfo.get("host"));
            response.setExpire(postSignInfo.get("expire"));
            response.setSuccess(true);

            return response;
        } catch (UnsupportedEncodingException e) {
            OpenException openException = new OpenException();
            openException.setErrMsg("获取临时授权失败");
            response.setException(openException);
            response.setSuccess(false);
            return response;
        }
    }

}
