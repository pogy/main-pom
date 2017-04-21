package com.shigu.sysman.spread.vo;


/**
 *
 *
 */
public class GoatFieldValueVo {

    /**
     * 值ID
     */
    private Long vid;
    /**
     * 列ID
     */
    private Long fid;
    /**
     * 广告ID
     */
    private Long goatId;
    /**
     * 值
     */
    private String value;

    public Long getVid() {
        return vid;
    }

    public void setVid(Long vid) {
        this.vid = vid;
    }

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public Long getGoatId() {
        return goatId;
    }

    public void setGoatId(Long goatId) {
        this.goatId = goatId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
