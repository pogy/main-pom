package com.opentae.data.mall.beans;

/**
 * 带值的广告
 * Created by Licca on 17/4/10.
 */
public class GoatItemWithField extends GoatItem{
    /**
     * 属性ID
     */
    private Long fid;
    /**
     * 属性值
     */
    private String value;
    /**
     * 属性值ID
     */
    private Long vid;

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getVid() {
        return vid;
    }

    public void setVid(Long vid) {
        this.vid = vid;
    }
}
