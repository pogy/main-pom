package com.shigu.phone.basevo;

import java.io.Serializable;

/**
 * Created By pc on 2017-10-17/18:40
 */
public class AboutMeVO implements Serializable {
    //头像
    private String headUrl;
    //用户昵称
    private String userNick;
    //绑定的手机
    private String phoneBind;

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public String getPhoneBind() {
        return phoneBind;
    }

    public void setPhoneBind(String phoneBind) {
        this.phoneBind = phoneBind;
    }
}
