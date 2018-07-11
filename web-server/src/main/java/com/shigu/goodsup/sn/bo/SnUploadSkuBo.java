package com.shigu.goodsup.sn.bo;


import java.util.List;

public class SnUploadSkuBo {
    private String pid;
    private String name;
    private List<SnUploadSkuBo> sizes;
    private Integer num;
    private String price;
    private String code;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SnUploadSkuBo> getSizes() {
        return sizes;
    }

    public void setSizes(List<SnUploadSkuBo> sizes) {
        this.sizes = sizes;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
