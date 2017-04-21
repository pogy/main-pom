package com.shigu.main4.vo;

import java.io.Serializable;

/**
 * 拒绝关店理由
 * Created by zhaohongbo on 17/3/10.
 */
public class RefuseOpenReason implements Serializable{
    private String who;
    private String reason;

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "["+who+"]"+reason;
    }
}
