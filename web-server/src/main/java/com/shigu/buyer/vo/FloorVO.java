package com.shigu.buyer.vo;

import java.io.Serializable;

/**
 * 楼层
 * Created by zhaohongbo on 17/3/3.
 */
public class FloorVO implements Serializable{
    /**
     * 楼层ID
     */
    private Long id;
    /**
     * 名称
     */
    private String name;

    public FloorVO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
