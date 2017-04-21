package com.shigu.buyer.vo;

import java.io.Serializable;

/**
 * 市场值
 * Created by zhaohongbo on 17/3/3.
 */
public class MarketVO implements Serializable{

    private Long id;

    private String name;

    public MarketVO(Long id, String name) {
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
