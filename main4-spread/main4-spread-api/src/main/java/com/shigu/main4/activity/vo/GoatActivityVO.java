package com.shigu.main4.activity.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 广告售卖活动数据体
 * Created by zhaohongbo on 17/5/4.
 */
public class GoatActivityVO extends ActivityVO implements Serializable{
    /**
     * 广告ID
     */
    private Long localId;
    /**
     * 广告编号
     */
    private String code;

    private List<GoatSimpleVO> goats;

    public Long getLocalId() {
        return localId;
    }

    public void setLocalId(Long localId) {
        this.localId = localId;
    }

    public List<GoatSimpleVO> getGoats() {
        return goats;
    }

    public void setGoats(List<GoatSimpleVO> goats) {
        this.goats = goats;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
