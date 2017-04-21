package com.shigu.seller.bo;

/**
 * 手动推荐商品获取
 * Created by Administrator on 2017/4/20 0020.
 */
public class PromotePagerBo {
    private Integer size = 5;
    private Integer page = 1;
    private Long id;
    private Long mid;
    private Long area;
    private Integer type;

    private String q;
    private Double lowPrice;
    private Double highPrice;

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    public Integer getType() {
        return type;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public Double getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(Double lowPrice) {
        this.lowPrice = lowPrice;
    }

    public Double getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(Double highPrice) {
        this.highPrice = highPrice;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
