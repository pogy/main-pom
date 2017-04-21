package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 店铺微信临时存储表
 *
 * @author shigu_zjb
 * @date 2017/2/10 13:21
 *
 */
@Deprecated
public class ShiguStoreWx {

    /** 店铺ID */
    @Id
    @GeneratedValue(
            generator = "JDBC"
    )
    private Long storeId;

    /** 微信 */
    private String imWx;

    /** website */
    private String webSite;

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getImWx() {
        return imWx;
    }

    public void setImWx(String imWx) {
        this.imWx = imWx;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }
}
