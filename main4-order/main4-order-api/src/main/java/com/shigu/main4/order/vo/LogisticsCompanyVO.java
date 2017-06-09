package com.shigu.main4.order.vo;

import java.io.Serializable;

/**
 * 物流公司
 * Created by zhaohongbo on 17/6/1.
 */
public class LogisticsCompanyVO extends OrderConstantVo implements Serializable{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
