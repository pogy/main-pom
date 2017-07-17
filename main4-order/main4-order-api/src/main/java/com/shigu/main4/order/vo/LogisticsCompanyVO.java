package com.shigu.main4.order.vo;

import java.io.Serializable;

/**
 * 物流公司
 * Created by zhaohongbo on 17/6/1.
 */
public class LogisticsCompanyVO extends OrderConstantVo implements Serializable{

    private String name;

    private String prov;

    private String startWeight;

    private String startPrice;

    private String addWeight;

    private String addPrice;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }

    public String getStartWeight() {
        return startWeight;
    }

    public void setStartWeight(String startWeight) {
        this.startWeight = startWeight;
    }

    public String getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(String startPrice) {
        this.startPrice = startPrice;
    }

    public String getAddWeight() {
        return addWeight;
    }

    public void setAddWeight(String addWeight) {
        this.addWeight = addWeight;
    }

    public String getAddPrice() {
        return addPrice;
    }

    public void setAddPrice(String addPrice) {
        this.addPrice = addPrice;
    }
}
