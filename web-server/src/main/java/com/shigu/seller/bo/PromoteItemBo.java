package com.shigu.seller.bo;

/**
 * 商品推荐请求业务
 * Created by Administrator on 2017/4/20 0020.
 */
public class PromoteItemBo {

    private Long mid;
    private Long area;
    private Integer type;
    private Long id;

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

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
