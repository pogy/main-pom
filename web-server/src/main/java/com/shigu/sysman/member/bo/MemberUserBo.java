package com.shigu.sysman.member.bo;


import com.shigu.component.common.page.PageParameter;

/**
 * 用户bo
 *
 * @author shigu_zjb
 * @date 2017/04/03 13:39
 *
 */
public class MemberUserBo extends PageParameter{

    /** userId */
    private Long userId;

    /** 登录手机号 */
    private String loginPhone;

    /** 用户名 */
    private String userName;

    /** 用户昵称 */
    private String userNick;

    /** 子账号 */
    private String subUserName;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLoginPhone() {
        return loginPhone;
    }

    public void setLoginPhone(String loginPhone) {
        this.loginPhone = loginPhone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public String getSubUserName() {
        return subUserName;
    }

    public void setSubUserName(String subUserName) {
        this.subUserName = subUserName;
    }
}
