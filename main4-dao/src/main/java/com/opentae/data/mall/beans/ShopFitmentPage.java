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
public class ShopFitmentPage implements Serializable {
    private static final long serialVersionUID = 1920229147657071228L;
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long pageId;

    /**
     * 页面名称
     */
    private String name;

    /**
     * 店铺ID
     */
    private Long shopId;

    /**
     * 1、首页，2搜索页，3、用户自定义',
     */
    private Integer type;

    /**
     * 页面code，用作页面地址，店铺内唯一
     */
    private Long code;

    /**
     *  '背景图',
     */
    private String backgroundPic;

    /**
     * '1、平铺，2、纵向平铺，3、横向平铺，4、不平铺',
     */
    private Integer backgroundType;

    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getBackgroundPic() {
        return backgroundPic;
    }

    public void setBackgroundPic(String backgroundPic) {
        this.backgroundPic = backgroundPic;
    }

    public Integer getBackgroundType() {
        return backgroundType;
    }

    public void setBackgroundType(Integer backgroundType) {
        this.backgroundType = backgroundType;
    }
}
