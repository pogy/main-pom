package com.shigu.main4.order.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 物流公司
 * Created by zhaohongbo on 17/6/1.
 */
public class LogisticsCompanyVO extends OrderConstantVo implements Serializable{

    /**
     * 物流公司代号
     */
    private String name;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
