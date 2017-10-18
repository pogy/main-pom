package com.shigu.phone.waps.service;

import com.openJar.beans.app.AppUser;
import com.openJar.exceptions.OpenException;
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
import com.shigu.phone.apps.services.PhoneUserService;
import com.shigu.phone.basebo.BindUserBO;
import com.shigu.phone.baseservices.BasePhoneUserService;
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

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 类名：PhoneUserService
 * 类路径：com.shigu.phone.apps.baseservices.PhoneUserService
 * 创建者：王浩翔
 * 创建时间：2017-08-31 17:04
 * 项目：main-pom
 * 描述：移动端用户服务
 */
@Service
public class WapPhoneUserService {

    @Autowired
    private BasePhoneUserService basePhoneUserService;

    /**
     * 移动端我的信息
     *
     * @return
     */
    public AboutMeVO aboutMe( Long userId) {
        return basePhoneUserService.aboutMe(userId);
    }

    /**
     * 移动端登录
     */
    public AppUser login( String userName,String password,Integer phoneType,String remoteAddr) throws OpenException {
        return basePhoneUserService.login(userName, password, phoneType, remoteAddr);
    }

    //第三方登录
    public String  ortherLogin(Integer type,String nick,String key ) {
        return basePhoneUserService.ortherLogin(type,nick,key);
    }

    /**
     * 得到手机验证码
     */
    public String getPhoneMsg(String telephone,Integer type) throws OpenException {
        return basePhoneUserService.getPhoneMsg(telephone,type);
    }

    /**
     * 移动端修改密码
     *
     * @return
     */
    public void changePassword( String oldPwd,String newPwd,Long userId,String token) throws OpenException {
        basePhoneUserService.changePassword(oldPwd,newPwd,userId,token);
    }

    //忘记密码
    public void forgetPassword( String telePhone,String msgCode,String newPwd ) throws OpenException {
        basePhoneUserService.forgetPassword(telePhone,msgCode,newPwd);
    }

    /**
     * 移动端用户注册
     * @return
     */
    public AppUser regist( String telePhone,String msgCode,String pwd) throws OpenException {
        return basePhoneUserService.regist(telePhone, msgCode, pwd);
    }

    /**
     * 移动端绑定手机
     * @return
     */
    public BindUserVO bindUser(BindUserBO bo) throws OpenException {
        return basePhoneUserService.bindUser(bo);
    }


    public void imgUpload(Long userId,String file) throws OpenException {
        UserInfoUpdate userInfoUpdate = new UserInfoUpdate();
        userInfoUpdate.setUserId(userId);
        userInfoUpdate.setHeadUrl(file);
        basePhoneUserService.imgUpload(userInfoUpdate);
    }

    /**
     * 获取 OSS 临时授权
     * @return
     */
    public CreatePostSignInfoVO createPostSignInfo() throws OpenException {
       return basePhoneUserService.createPostSignInfo();
    }

}
