package com.shigu.main4.spread.bo;

import java.io.Serializable;

/**
 * 用户抽奖
 * Created by zhaohongbo on 17/7/31.
 */
public class ActiveDrawRecordBO implements Serializable {

    private Long pemId;

    private Long userId;

    private String ward;

    public Long getPemId() {
        return pemId;
    }

    public void setPemId(Long pemId) {
        this.pemId = pemId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }
}
