package com.shigu.main4.activity.vo;

import java.io.Serializable;

/**
 * 广告售卖活动数据体
 * Created by zhaohongbo on 17/5/4.
 */
public class GoatActivityVO extends ActivityVO implements Serializable{
    /**
     * 广告ID
     */
    private Long goatId;
    /**
     * 广告编号
     */
    private String code;

    public Long getGoatId() {
        return goatId;
    }

    public void setGoatId(Long goatId) {
        this.goatId = goatId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
