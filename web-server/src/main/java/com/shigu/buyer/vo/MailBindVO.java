package com.shigu.buyer.vo;

import java.io.Serializable;

/**
 * 邮箱绑定的值
 * Created by zhaohongbo on 17/3/14.
 */
public class MailBindVO implements Serializable{

    private String email;

    private String msg;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
