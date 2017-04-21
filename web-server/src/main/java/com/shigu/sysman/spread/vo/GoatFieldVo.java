package com.shigu.sysman.spread.vo;

/**
 * Created by Administrator on 2017-04-10.
 */
public class GoatFieldVo {

    private Long fid;
    /**
     * 属性标题
     */
    private String title;
    /**
     * 1文本、2图片
     */
    private Integer fieldType;
    /**
     * 是否必款
     */
    private Boolean mustHave;
    /**
     * 最大长度
     */
    private Integer maxLength;
    /**
     * 广告位置ID
     */
    private Long locationId;
    /**
     * 变量名
     */
    private String fieldName;

    private String values;

    private Long vId;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getFieldType() {
        return fieldType;
    }

    public void setFieldType(Integer fieldType) {
        this.fieldType = fieldType;
    }

    public Boolean getMustHave() {
        return mustHave;
    }

    public void setMustHave(Boolean mustHave) {
        this.mustHave = mustHave;
    }

    public Integer getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public Long getvId() {
        return vId;
    }

    public void setvId(Long vId) {
        this.vId = vId;
    }
}
