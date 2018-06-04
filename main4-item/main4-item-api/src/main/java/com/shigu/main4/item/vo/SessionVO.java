package com.shigu.main4.item.vo;

import java.io.Serializable;

/**
 * session对象
 * Created by zhaohongbo on 17/3/3.
 */
public class SessionVO implements Serializable{

    private String appkey;

    private String session;

    private Long tbUserId;

    private String nick;

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Long getTbUserId() {
        return tbUserId;
    }

    public void setTbUserId(Long tbUserId) {
        this.tbUserId = tbUserId;
    }

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }
}
