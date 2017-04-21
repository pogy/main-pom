package com.shigu.sysman.spread.vo;

/**
 * Created by Administrator on 2017-04-10.
 */
public class GoatModelVo {

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
