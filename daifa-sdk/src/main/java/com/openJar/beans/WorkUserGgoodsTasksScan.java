package com.openJar.beans;

import com.openJar.utils.OpenBean;

/**
 * @ProjectName: main-pom
 * @Package: com.openJar.beans.enums
 * @ClassName: WorkUserGgoodsTasksScan
 * @Author: sy
 * @CreateDate: 2018/7/19 0019 16:54
 */
public class WorkUserGgoodsTasksScan extends OpenBean {

    private String scanBarCode;
    private String storeGoodsCode;
    private Double price;

    public String getScanBarCode() {
        return scanBarCode;
    }

    public void setScanBarCode(String scanBarCode) {
        this.scanBarCode = scanBarCode;
    }

    public String getStoreGoodsCode() {
        return storeGoodsCode;
    }

    public void setStoreGoodsCode(String storeGoodsCode) {
        this.storeGoodsCode = storeGoodsCode;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
