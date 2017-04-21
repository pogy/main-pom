package com.shigu.main4.spread.vo;

/**
 * 广告列
 * Created by Licca on 17/4/10.
 */
public class GoatFieldVO {
    /**
     * 列ID
     */
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
     * 是否必填
     */
    private Boolean mustHave;
    /**
     * 最大长度
     */
    private Integer maxLength;
    /**
     * 列变量名
     */
    private String fieldName;

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Integer getFieldType() {
        return fieldType;
    }

    public void setFieldType(Integer fieldType) {
        this.fieldType = fieldType;
    }

    public Integer getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
    }

    public Boolean getMustHave() {
        return mustHave;
    }

    public void setMustHave(Boolean mustHave) {
        this.mustHave = mustHave;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoatFieldVO that = (GoatFieldVO) o;

        return !(fid != null ? !fid.equals(that.fid) : that.fid != null);

    }

    @Override
    public int hashCode() {
        return fid != null ? fid.hashCode() : 0;
    }
}
