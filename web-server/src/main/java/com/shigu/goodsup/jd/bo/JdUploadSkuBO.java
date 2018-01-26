package com.shigu.goodsup.jd.bo;

import java.util.List;

public class JdUploadSkuBO {
    private Long pid;
    private Long vid;
    private String name;
    private List<JdUploadSkuBO> sizes;
    private Integer num;
    private String price;
    private String code;

    public Long getPid() {
        return this.pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getVid() {
        return this.vid;
    }

    public void setVid(Long vid) {
        this.vid = vid;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<JdUploadSkuBO> getSizes() {
        return this.sizes;
    }

    public void setSizes(List<JdUploadSkuBO> sizes) {
        this.sizes = sizes;
    }

    public Integer getNum() {
        return this.num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
