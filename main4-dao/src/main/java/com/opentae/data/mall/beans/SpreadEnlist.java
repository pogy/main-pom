package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 报名记录
 * Created by zhaohongbo on 17/5/4.
 */
public class SpreadEnlist implements Serializable{
    /**
     * 报名记录ID
     */
    @Id
    @GeneratedValue(
            generator = "JDBC"
    )
    private Long enlistId;
    /**
     * 联系人名
     */
    private String name;
    /**
     * 联系人手机
     */
    private String telephone;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 店铺ID
     */
    private Long shopId;
    /**
     * 1中奖，0不中
     */
    private Integer draw;

    public Long getEnlistId() {
        return enlistId;
    }

    public void setEnlistId(Long enlistId) {
        this.enlistId = enlistId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

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

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }
}
