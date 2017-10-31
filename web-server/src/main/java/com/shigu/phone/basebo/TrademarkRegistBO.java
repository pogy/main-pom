package com.shigu.phone.basebo;

import java.io.Serializable;

/**
 * Created By pc on 2017-10-27/14:26
 * 商标注册入参
 */
public class TrademarkRegistBO implements Serializable {
    /**用户姓名*/
    private String userName;
    /**用户手机号码*/
    private String userTele;
    /**注册类型 1:商标普通注册,2:商标加急注册,3:商标担保注册,4:商标双享注册,5:普通登记,6:加急登记,7:外观专利,8:设计稿作品*/
    private String type;
    /**要求说明*/
    private String askFor;
    /**apptken*/
    private String token;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserTele() {
        return userTele;
    }

    public void setUserTele(String userTele) {
        this.userTele = userTele;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAskFor() {
        return askFor;
    }

    public void setAskFor(String askFor) {
        this.askFor = askFor;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
