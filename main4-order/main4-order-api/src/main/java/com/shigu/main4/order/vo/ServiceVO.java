package com.shigu.main4.order.vo;

import java.io.Serializable;

/**
 * 服务种类
 * Created by zhaohongbo on 17/5/31.
 */
public class ServiceVO implements Serializable{
    /**
     * id
     */
    private Long id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 价格
     */
    private Long price;
    /**
     * 详细资料
     */
    private String detail;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
