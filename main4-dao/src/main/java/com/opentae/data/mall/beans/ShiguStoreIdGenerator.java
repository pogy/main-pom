package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by zhaohongbo on 16/7/22.
 */
@Deprecated
public class ShiguStoreIdGenerator {
    @Id
    @GeneratedValue(
            generator = "JDBC"
    )
    private Long storeId;
    private String webSite;
    private Long userId;
    private String remark;

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
