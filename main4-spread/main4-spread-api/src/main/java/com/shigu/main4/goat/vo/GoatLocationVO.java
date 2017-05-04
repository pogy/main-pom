package com.shigu.main4.goat.vo;

import java.io.Serializable;

/**
 * 广告位置
 * Created by zhaohongbo on 17/5/4.
 */
public class GoatLocationVO implements Serializable{
    /**
     * 广告位置ID
     */
    private Long localId;
    /**
     * 广告位编号
     */
    private String code;
    /**
     * 广告描述
     */
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
