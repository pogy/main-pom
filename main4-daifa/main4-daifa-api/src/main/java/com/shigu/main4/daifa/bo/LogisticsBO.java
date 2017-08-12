package com.shigu.main4.daifa.bo;

import java.io.Serializable;

/**
 * Created by jmb on 2017/8/11.
 * Path com.shigu.main4.daifa.bo.LogisticsBO
 */
public class LogisticsBO implements Serializable {
    private Long companyId;//     物流公司ID
    private String company;//        物流公司
    private Double money;//         支付的费用
    private Long provId;//         省份ID
    private String prov;//            省份
    private Long cityId;//           城市ID
    private String city;//              城市
    private  Long townId;//         区ID
    private String town;//            区
    private String address ;//      详细地址
    private String telephone;//    手机号
    private String name;//           收件人姓名
    private String zip_code;//      邮编

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Long getProvId() {
        return provId;
    }

    public void setProvId(Long provId) {
        this.provId = provId;
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getTownId() {
        return townId;
    }

    public void setTownId(Long townId) {
        this.townId = townId;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }
}
