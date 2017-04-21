package com.shigu.buyer.bo;

/**
 * 登陆信息
 * Created by zhaohongbo on 17/2/25.
 */
public class LoginBO {
    /**
     * 账号
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 回调用地址
     */
    private String backUrl;

    public String getBackUrl() {
        return backUrl;
    }

    public void setBackUrl(String backUrl) {
        this.backUrl = backUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 空判断
     * @return
     */
    public boolean isEmpty(){
        return (userName==null|| userName.equals(""))&&(password==null||password.equals(""));
    }
}
