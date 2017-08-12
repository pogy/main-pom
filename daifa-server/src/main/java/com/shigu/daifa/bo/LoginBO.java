package com.shigu.daifa.bo;

import java.io.Serializable;

/**
 * @类编号
 * @类名称：LoginBO
 * @文件路径：com.shigu.daifa.bo.LoginBO
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/8/12 18:05
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class LoginBO implements Serializable{
    private String username;
    private String password;

    public String getUsername () {
        return username;
    }

    public void setUsername (String username) {
        this.username = username;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }
}
