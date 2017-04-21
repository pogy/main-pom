package com.shigu.session.main4;

import java.io.Serializable;

/**
 * 普通用户登陆的session
 * Created by zhaohongbo on 17/1/5.
 */
public class UserLoginSession implements Serializable{
    private static final long serialVersionUID = -1318942972946843453L;
    private Long userId;//用户ID
    private Long accountId;//用户子表ID
    private String userNick;//用户昵称
    private  Integer accountType;//账户类型子账号类型@1手机2邮箱3淘宝账号4QQ账号5微信6阿里7用户名(主账号)
    private String loginType;//登陆方式：主账号登陆,手机号登陆,邮箱登陆，QQ登陆,微信登陆,淘宝登陆,阿里登陆
    private String loginName;//登录名
    private String subUserKey;//子账户的唯一标识
    private String loginTime;//本次登陆时间
    private String lastLoginTime;//上次登陆时间
    private boolean phonecheck;//手机绑定true为绑定过false为没有绑定过
    private boolean emailckeck;//邮件验证true为绑定过false为没有绑定过
    private String portraitUrl;//头像地址
    private boolean taonew;//是否是淘宝新建账户
    private Integer userType;
    private String phoneMob;
    private String portraitSavepath;

    private String userName;// 用户名称
    private String imAliww;// 阿里旺旺
    private String imNick;// 用户昵称


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getSubUserKey() {
        return subUserKey;
    }

    public void setSubUserKey(String subUserKey) {
        this.subUserKey = subUserKey;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public boolean isPhonecheck() {
        return phonecheck;
    }

    public void setPhonecheck(boolean phonecheck) {
        this.phonecheck = phonecheck;
    }

    public boolean isEmailckeck() {
        return emailckeck;
    }

    public void setEmailckeck(boolean emailckeck) {
        this.emailckeck = emailckeck;
    }

    public String getPortraitUrl() {
        return portraitUrl;
    }

    public void setPortraitUrl(String portraitUrl) {
        this.portraitUrl = portraitUrl;
    }

    public boolean isTaonew() {
        return taonew;
    }

    public void setTaonew(boolean taonew) {
        this.taonew = taonew;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getPhoneMob() {
        return phoneMob;
    }

    public void setPhoneMob(String phoneMob) {
        this.phoneMob = phoneMob;
    }

    public String getPortraitSavepath() {
        return portraitSavepath;
    }

    public void setPortraitSavepath(String portraitSavepath) {
        this.portraitSavepath = portraitSavepath;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getImAliww() {
        return imAliww;
    }

    public void setImAliww(String imAliww) {
        this.imAliww = imAliww;
    }

    public String getImNick() {
        return imNick;
    }

    public void setImNick(String imNick) {
        this.imNick = imNick;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.getUserNick()+"["+this.getUserId()+"]";
    }
}
