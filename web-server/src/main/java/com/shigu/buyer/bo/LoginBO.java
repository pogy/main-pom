package com.shigu.buyer.bo;

/**
 * 登陆信息
 * Created by zhaohongbo on 17/2/25.
 */
public class LoginBO {
    /**
     * 账号
     */
    private String username;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        return (username ==null|| username.equals(""))&&(password==null||password.equals(""));
    }
}
