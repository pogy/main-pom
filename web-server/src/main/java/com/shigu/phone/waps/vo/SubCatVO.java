package com.shigu.phone.waps.vo;

import java.io.Serializable;

/**
 * Created By pc on 2017-10-19/16:38
 */
public class SubCatVO implements Serializable {
    /**子分类id*/
    private String cid;
    /**总分类名称*/
    private String name;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
