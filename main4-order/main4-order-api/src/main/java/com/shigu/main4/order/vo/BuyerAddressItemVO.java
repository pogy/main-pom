package com.shigu.main4.order.vo;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/7/17.
 */
public class BuyerAddressItemVO implements Serializable {
     private String name;
     private String phone;
     private Long provId;
     private Long cityId;
     private Long countyId;
     private String address;
     private String type;

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone( String phone ) {
        this.phone = phone;
    }

    public Long getProvId() {
        return provId;
    }

    public void setProvId( Long provId ) {
        this.provId = provId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId( Long cityId ) {
        this.cityId = cityId;
    }

    public Long getCountyId() {
        return countyId;
    }

    public void setCountyId( Long countyId ) {
        this.countyId = countyId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress( String address ) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType( String type ) {
        this.type = type;
    }
}
