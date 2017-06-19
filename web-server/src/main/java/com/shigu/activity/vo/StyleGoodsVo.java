package com.shigu.activity.vo;

import java.io.Serializable;

/**
 * 商品数据
 * Created by bugzy on 2017/5/18 0018.
 */
public class StyleGoodsVo implements Serializable {
    private Long id;
    private String imgsrc;
    private String piprice;
    private String fullStoreName;
    private Long storeid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public String getPiprice() {
        return piprice;
    }

    public void setPiprice(String piprice) {
        this.piprice = piprice;
    }

    public String getFullStoreName() {
        return fullStoreName;
    }

    public void setFullStoreName(String fullStoreName) {
        this.fullStoreName = fullStoreName;
    }

    public Long getStoreid() {
        return storeid;
    }

    public void setStoreid(Long storeid) {
        this.storeid = storeid;
    }
}
