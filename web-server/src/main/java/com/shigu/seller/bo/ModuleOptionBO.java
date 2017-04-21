package com.shigu.seller.bo;

import java.io.Serializable;

/**
 * 模块区域
 * Created by zhaohongbo on 17/4/18.
 */
public class ModuleOptionBO implements Serializable{
    /**
     * 模块ID
     */
    private Long id;
    /**
     * 区域
     */
    private Long area;
    /**
     * 排版
     * 1\2\3
     */
    private Integer type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
