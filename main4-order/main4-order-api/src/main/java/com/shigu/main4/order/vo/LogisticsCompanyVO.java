package com.shigu.main4.order.vo;

import java.io.Serializable;

/**
 * 物流公司
 * Created by zhaohongbo on 17/6/1.
 */
public class LogisticsCompanyVO implements Serializable{

    private Long id;
    /**
     * 物流公司代号
     */
    private String name;

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
