package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by wxc on 2017/4/14.
 *
 * @author wxc
 * @version main_site4.0 4.0.0
 * @since main_site4.0 4.0.0
 */
public class ShopFitmentArea implements Serializable {
    private static final long serialVersionUID = 6690118918723258919L;

    /**
     * 区域ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long areaId;

    /**
     * 店铺ID
     */
    private Long shopId;

    /**
     * 页面ID
     */
    private Long pageId;

    /**
     * 在哪个区域后
     */
    private Long afterAreaId;

    /**
     * 2、顶部页头，这种区域不需要page_id，3、左右区域 1、通栏区域
     */
    private Integer areaType;

    /**
     * true是可以，false是不可以
     */
    private Boolean canDel;

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }

    public Long getAfterAreaId() {
        return afterAreaId;
    }

    public void setAfterAreaId(Long afterAreaId) {
        this.afterAreaId = afterAreaId;
    }

    public Integer getAreaType() {
        return areaType;
    }

    public void setAreaType(Integer areaType) {
        this.areaType = areaType;
    }

    public Boolean getCanDel() {
        return canDel;
    }

    public void setCanDel(Boolean canDel) {
        this.canDel = canDel;
    }
}
