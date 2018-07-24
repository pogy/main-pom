package com.shigu.spread.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 类名：InviteGoodsVO
 * 类路径： com.shigu.spread.vo.InviteGoodsVO
 * 创建者： whx
 * 创建时间： 7/24/18 2:23 PM
 * 项目： main-pom
 * 描述：
 */
public class InviteGoodsVO implements Serializable {

    private Long id;

    private String imgsrc;

    private String title;

    private Long piPrice;

    private String piprice;

    private Long shopId;

    private List<String> services;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getPiPrice() {
        return piPrice;
    }

    public void setPiPrice(Long piPrice) {
        this.piPrice = piPrice;
    }

    public String getPiprice() {
        return piprice;
    }

    public void setPiprice(String piprice) {
        this.piprice = piprice;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public List<String> getServices() {
        return services;
    }

    public void setServices(List<String> services) {
        this.services = services;
    }
}
