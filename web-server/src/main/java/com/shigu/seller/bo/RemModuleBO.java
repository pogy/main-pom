package com.shigu.seller.bo;

import java.io.Serializable;

/**
 * 移除模块
 * Created by zhaohongbo on 17/4/18.
 */
public class RemModuleBO implements Serializable{
    /**
     * 模块ID
     */
    private Long id;
    /**
     * 区域ID
     */
    private Long area;
    /**
     * 位置类别
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
