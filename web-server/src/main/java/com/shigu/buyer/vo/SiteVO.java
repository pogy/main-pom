package com.shigu.buyer.vo;

import java.io.Serializable;

/**
 * 给入驻用的站点
 * Created by zhaohongbo on 17/3/3.
 */
public class SiteVO implements Serializable{
    /**
     * 标识
     */
    private String id;
    /**
     * 名称
     */
    private String name;

    public SiteVO(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
