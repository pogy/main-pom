package com.shigu.main4.ucenter.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 用户安全信息
 * Created by zhaohongbo on 17/3/1.
 */
public class SafeAbout implements Serializable{
    /**
     * 评分,分数
     */
    private int score;
    /**
     * 权益
     */
    private List<UserLicense> licenses;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<UserLicense> getLicenses() {
        return licenses;
    }

    public void setLicenses(List<UserLicense> licenses) {
        this.licenses = licenses;
    }
}
