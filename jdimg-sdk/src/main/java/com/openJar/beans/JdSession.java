package com.openJar.beans;

import java.io.Serializable;

/**
 * Created by gtx on 2018/5/8.
 * 京东用户信息
 * @author gtx
 * @description
 * @since
 */
public class JdSession implements Serializable {
    /**
     * 用户的京东uid
     */
    private Long jdUid;

    /**
     * 用户京东昵称
     */
    private String jdUserNick;

    public Long getJdUid() {
        return jdUid;
    }

    public void setJdUid(Long jdUid) {
        this.jdUid = jdUid;
    }

    public String getJdUserNick() {
        return jdUserNick;
    }

    public void setJdUserNick(String jdUserNick) {
        this.jdUserNick = jdUserNick;
    }
}
