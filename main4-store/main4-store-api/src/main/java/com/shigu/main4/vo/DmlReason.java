package com.shigu.main4.vo;

import java.io.Serializable;

/**
 * 用户对店铺做开店或关店的原因
 * Created by zhaohongbo on 17/2/28.
 */
public class DmlReason implements Serializable{
    /**
     * 操作人
     */
    private String who;
    /**
     * 干了什么,关店或开店
     */
    private String doWhat;
    /**
     * 原因
     */
    private String reason;

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public String getDoWhat() {
        return doWhat;
    }

    public void setDoWhat(String doWhat) {
        this.doWhat = doWhat;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "["+who+"-"+doWhat+"]"+reason;
    }
}
