package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 店铺权益
 * Created by zhaohongbo on 17/2/17.
 */
public class ShiguShopLicense implements Serializable{
    private static final long serialVersionUID = -4136867394302744898L;
    /**
     * 主键
     */
    @Id
    @GeneratedValue(
            generator = "JDBC"
    )
    private Long licenseId;
    /**
     * 店铺ID
     */
    private Long shopId;
    /**
     * 公益类型
     1、身份证认证，内容为身份证图片
     2、工商认证，内容为营业执照
     3、实体认证，内容为店面照片
     4、合同认证，内容为租赁合同
     5、标签授予，内容为标签种类ID
     6、星星数
     */
    private Integer licenseType;
    /**
     * 权益内容
     */
    private String context;
    /**
     * 权益有效性，0表示有效，1表示失效,默认0
     */
    private Integer licenseFailure;

    public Long getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(Long licenseId) {
        this.licenseId = licenseId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Integer getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(Integer licenseType) {
        this.licenseType = licenseType;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Integer getLicenseFailure() {
        return licenseFailure;
    }

    public void setLicenseFailure(Integer licenseFailure) {
        this.licenseFailure = licenseFailure;
    }
}
