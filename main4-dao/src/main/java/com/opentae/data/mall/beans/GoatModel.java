package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 广告模板
 * Created by zhaohongbo on 17/4/9.
 */
public class GoatModel {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator="JDBC")
    private Long modelId;
    /**
     * 模板内容
     */
    private String modelHtml;
    /**
     * 广告位置ID
     */
    private Long locationId;

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public String getModelHtml() {
        return modelHtml;
    }

    public void setModelHtml(String modelHtml) {
        this.modelHtml = modelHtml;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }
}
