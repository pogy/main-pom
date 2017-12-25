package com.shigu.main4.monitor.bo;

import java.io.Serializable;

/**
 *App用户bug反馈
 */
public class ShiguFeedbackBO implements Serializable{
    /**用户ID*/
    private Long userId;
    /**反馈内容*/
    private String fcontents;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFcontents() {
        return fcontents;
    }

    public void setFcontents(String fcontents) {
        this.fcontents = fcontents;
    }
}
