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
public class ShopFitmentFtl implements Serializable {
    private static final long serialVersionUID = 8049114591827042421L;
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long ftlId;

    /**
     * 页面ID
     */
    private Long pageId;

    /**
     * 模板原文
     */
    private String context;
    /**
     * 店铺ID
     */
    private Long shopId;
    /**
     * 1、banner,2、page
     */
    private Integer type;

    public Long getFtlId() {
        return ftlId;
    }

    public void setFtlId(Long ftlId) {
        this.ftlId = ftlId;
    }

    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
