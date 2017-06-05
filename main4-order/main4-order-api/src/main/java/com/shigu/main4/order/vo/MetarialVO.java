package com.shigu.main4.order.vo;

import java.io.Serializable;

/**
 * 包材
 * Created by zhaohongbo on 17/5/31.
 */
public class MetarialVO implements Serializable{
    /**
     * id
     */
    private Long id;
    /**
     * 包材名
     */
    private String name;
    /**
     * 价格
     */
    private Long price;
    /**
     * 尺码
     */
    private String size;

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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
