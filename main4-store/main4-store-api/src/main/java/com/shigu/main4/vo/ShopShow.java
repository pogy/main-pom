package com.shigu.main4.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 给市场显示的店铺
 * Created by zhaohongbo on 17/2/27.
 */
public class ShopShow implements Serializable{
    /**
     * 主键
     */
    private Long shopId;
    /**
     * 档口号
     */
    private String shopNum;
    /**
     * 档口名称
     */
    private String shopName;
    /**
     * 主营类目
     */
    private String mainBus;
    /**
     * 系统给的备注
     */
    private String systemComment;
    /**
     * 店铺logo图,暂时不用查
     */
    private String logo;

    /**
     * 排序作用的伪档口号
     */
    private String sortOrderKey;
    /**
     * 店铺标签属性
     */
    private List<Integer> tags;
    /**
     * 店铺创建时间
     */
    private Date createDate;
    /**
     * 楼层
     */
    private String floor;
    /**
     * 楼层ID
     */
    private Long floorId;

    public Long getFloorId() {
        return floorId;
    }

    public void setFloorId(Long floorId) {
        this.floorId = floorId;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public List<Integer> getTags() {
        return tags;
    }

    public void setTags(List<Integer> tags) {
        this.tags = tags;
    }

    public String getMainBus() {
        return mainBus;
    }

    public void setMainBus(String mainBus) {
        this.mainBus = mainBus;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getShopNum() {
        return shopNum;
    }

    public void setShopNum(String shopNum) {
        this.shopNum = shopNum;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getSystemComment() {
        return systemComment;
    }

    public void setSystemComment(String systemComment) {
        this.systemComment = systemComment;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getSortOrderKey() {
        return sortOrderKey;
    }

    public void setSortOrderKey(String sortOrderKey) {
        this.sortOrderKey = sortOrderKey;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
