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

    private Integer number;

    private String time;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Long getLocalId() {
        return localId;
    }

    public void setLocalId(Long localId) {
        this.localId = localId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return this.getDescription()+"x"+this.getNumber();
    }
}
