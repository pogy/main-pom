package com.shigu.phone.waps.service;

import com.openJar.beans.app.AppUser;
import com.openJar.exceptions.OpenException;
import com.shigu.main4.ucenter.vo.UserInfo;
import com.shigu.main4.ucenter.vo.UserInfoUpdate;
import com.shigu.phone.basebo.BindUserBO;
import com.shigu.phone.baseservices.BasePhoneUserService;
import com.shigu.phone.basevo.AboutMeVO;
import com.shigu.phone.basevo.BindUserVO;
import com.shigu.phone.basevo.CreatePostSignInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    public AppUser msgCodeLogin( String userName,String password,String remoteAddr) throws OpenException {
        return basePhoneUserService.msgCodeLogin(userName,password,remoteAddr);
    }

    /**
     * 得到手机验证码
     */
    public String getPhoneMsg(String telephone,Integer type) throws OpenException {
        return basePhoneUserService.getPhoneMsg(telephone,type);
    }

    /**
     * 修改密码
     *
     * @return
     */
    public void changePassword( String oldPwd,String newPwd,Long userId) throws OpenException {
        basePhoneUserService.changePassword(oldPwd,newPwd,userId);
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

    public UserInfo selUserInfo(Long userId){
        return basePhoneUserService.selUserInfo(userId);
    }

    /**
     * 获取 OSS 临时授权
     * @return
     */
    public CreatePostSignInfoVO createPostSignInfo() throws OpenException {
       return basePhoneUserService.createPostSignInfo();
    }

    /**
     * 是否需要绑定手机
     * @param userId
     */
    public boolean needBindTelephone(Long userId){
        return basePhoneUserService.needBindTelephone(userId);
    }

    public void bindTelephone(Long userId, Long telephone) throws OpenException {
        basePhoneUserService.bindTelephone(userId,telephone);
    }
}
