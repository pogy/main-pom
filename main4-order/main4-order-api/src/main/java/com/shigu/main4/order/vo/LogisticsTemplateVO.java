package com.shigu.main4.order.vo;

import java.util.List;

/**
 * 物流模板
 * Created by zhaohongbo on 17/7/19.
 */
public class LogisticsTemplateVO {
    /**
     * 快递模板ID
     */
    private Long templateId;
    /**
     * 发货单位ID
     */
    private Long senderId;

    private String title;

    private Long fromProvId;

    private Long fromCityId;

    private Long fromTownId;

    private List<LogisticsCompanyVO> companys;

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getFromProvId() {
        return fromProvId;
    }

    public void setFromProvId(Long fromProvId) {
        this.fromProvId = fromProvId;
    }

    public Long getFromCityId() {
        return fromCityId;
    }

    public void setFromCityId(Long fromCityId) {
        this.fromCityId = fromCityId;
    }

    public Long getFromTownId() {
        return fromTownId;
    }

    public void setFromTownId(Long fromTownId) {
        this.fromTownId = fromTownId;
    }

    public List<LogisticsCompanyVO> getCompanys() {
        return companys;
    }

    public void setCompanys(List<LogisticsCompanyVO> companys) {
        this.companys = companys;
    }
}
