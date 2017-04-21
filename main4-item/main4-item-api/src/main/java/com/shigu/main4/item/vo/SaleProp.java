package com.shigu.main4.item.vo;

import java.io.Serializable;

/**
 * 销售属性
 * Created by zhaohongbo on 17/2/16.
 */
public class SaleProp implements Serializable{

    private static final long serialVersionUID = -3925482982479868005L;
    /**
     * 属性ID
     */
    private Long pid;
    /**
     * 属性值ID
     */
    private Long vid;
    /**
     * 属性名
     */
    private String pname;
    /**
     * 属性值
     */
    private String value;
    /**
     * 属性图
     */
    private String imgUrl;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getVid() {
        return vid;
    }

    public void setVid(Long vid) {
        this.vid = vid;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
