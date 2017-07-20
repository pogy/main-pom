package com.shigu.main4.order.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 物流信息
 * Created by zhaohongbo on 17/5/31.
 */
public class LogisticsVO implements Serializable{

    private Long id;

    private Long companyId;

    private Long money;

    private Long provId;

    private Long cityId;

    private Long townId;

    private String address;

    private String telephone;

    private String zipCode;

    private String courierNumber;

    private String name;

    private List<Long> soids;

    public List<Long> getSoids() {
        return soids;
    }

    public void setSoids(List<Long> soids) {
        this.soids = soids;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public Long getProvId() {
        return provId;
    }

    public void setProvId(Long provId) {
        this.provId = provId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getTownId() {
        return townId;
    }

    public void setTownId(Long townId) {
        this.townId = townId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourierNumber() {
        return courierNumber;
    }

    public void setCourierNumber(String courierNumber) {
        this.courierNumber = courierNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "LogisticsVO{" +
                "id=" + id +
                ", companyId=" + companyId +
                ", money=" + money +
                ", provId=" + provId +
                ", cityId=" + cityId +
                ", townId=" + townId +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", courierNumber='" + courierNumber + '\'' +
                ", name='" + name + '\'' +
                ", soids=" + soids +
                '}';
    }
}
