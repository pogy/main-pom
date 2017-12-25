package com.shigu.main4.jd.vo;

import java.io.Serializable;

/**
 * Created By admin on 2017/12/25/15:25
 */
public class JdVenderBrandPubInfoVO implements Serializable {

    private static final long serialVersionUID = -3956812342395559204L;

    /**
     * ERP品牌ID
     */
    private Integer erpBrandId;
    /**
     * 品牌名称
     */
    private String brandName;

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
