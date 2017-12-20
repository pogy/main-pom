package com.shigu.order.vo;

import java.io.Serializable;

public class TbOrderAddressInfoVO implements Serializable {
    /**
     * 淘宝订单id
     */
    private Long id;
    /**
     * 	地址缓存id
     */
    private String addressId;
    /**
     * 淘宝订单收货人名字
     */
    private String name;
    /**
     * 淘宝订单收货省份
     */
    private String prov;
    /**
     * 淘宝订单收货地址(包含省.市.区.详细地址.收货人信息)
     */
    private String allAddressInfo;

    /**
     * 获取 淘宝订单id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * 设置 淘宝订单id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 	地址缓存id
     */
    public String getAddressId() {
        return this.addressId;
    }

    /**
     * 设置 	地址缓存id
     */
    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    /**
     * 获取 淘宝订单收货人名字
     */
    public String getName() {
        return this.name;
    }

    /**
     * 设置 淘宝订单收货人名字
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取 淘宝订单收货省份
     */
    public String getProv() {
        return this.prov;
    }

    /**
     * 设置 淘宝订单收货省份
     */
    public void setProv(String prov) {
        this.prov = prov;
    }

    /**
     * 获取 淘宝订单收货地址(包含省.市.区.详细地址.收货人信息)
     */
    public String getAllAddressInfo() {
        return this.allAddressInfo;
    }

    /**
     * 设置 淘宝订单收货地址(包含省.市.区.详细地址.收货人信息)
     */
    public void setAllAddressInfo(String allAddressInfo) {
        this.allAddressInfo = allAddressInfo;
    }
}
