package com.shigu.main4.vo;

import java.io.Serializable;

/**
 * 评论展示信息
 * Created by zhaohongbo on 17/2/22.
 */
public class Discus implements Serializable{
    /**
     * 用户ID,添加评论的时候用
     */
    private Long userId;
    /**
     * 店铺ID
     */
    private Long storeId;
    /**
     * 分站标识
     */
    private String webSite;
    /**
     * 发言人
     */
    private String who;
    /**
     * 说了什么
     */
    private String say;
    /**
     * 给分
     */
    private Integer giveScore;
    /**
     * 用户IP
     */
    private String ip;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public String getSay() {
        return say;
    }

    public void setSay(String say) {
        this.say = say;
    }

    public Integer getGiveScore() {
        return giveScore;
    }

    public void setGiveScore(Integer giveScore) {
        this.giveScore = giveScore;
    }
}
