package com.opentae.data.mall.beans;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 用户最后一次登陆的店铺
 *
 */
public class ShiguUserLastloginshop {

    @Id
    @GeneratedValue(
            generator = "JDBC"
    )
    /** 用户ID */
    private Long userId;

    /** 店铺ID */
    private Long shopId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
}
