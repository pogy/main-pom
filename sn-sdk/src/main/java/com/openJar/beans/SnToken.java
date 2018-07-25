package com.openJar.beans;

import com.openJar.utils.OpenBean;

import java.util.Date;

public class SnToken extends OpenBean {
    private String username;
    private Date createTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
