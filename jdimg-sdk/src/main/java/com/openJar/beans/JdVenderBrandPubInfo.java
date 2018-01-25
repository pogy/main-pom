package com.openJar.beans;

import com.openJar.utils.OpenBean;

import java.io.Serializable;

/**
 * Created By admin on 2018/1/16/13:55
 */
public class JdVenderBrandPubInfo extends OpenBean implements Serializable  {

    /**
     * ERP品牌ID
     */
    private Integer erpBrandId;
    /**
     * 品牌名称
     */
    private String brandName;

    public JdVenderBrandPubInfo() {
    }

    public Integer getErpBrandId() {
        return erpBrandId;
    }

    public void setErpBrandId(Integer erpBrandId) {
        this.erpBrandId = erpBrandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
