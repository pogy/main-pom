package com.shigu.main4.order.vo;

import java.io.Serializable;

/**
 * 服务种类
 * Created by zhaohongbo on 17/5/31.
 */
public class ServiceVO extends OrderConstantVo implements Serializable{
    /**
     * 姓名
     */
    private String name;
    /**
     * 价格
     */
    private Long price;
    /**
     * 类别
     *  1、正常代发的代发费,2、代拿的服务费
     */
    private Integer type;
    /**
     * 付费方式
     * 1、按单付费,2、按sku付费,3、按件付费
     */
    private Integer feeType;
    /**
     * 分站
     */
    private String webSite;
    /**
     * 市场ID
     */
    private Long marketId;
    /**
     * 详细资料
     */
    private String detail;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getFeeType() {
        return feeType;
    }

    public void setFeeType(Integer feeType) {
        this.feeType = feeType;
    }

    public Long getMarketId() {
        return marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }
}
