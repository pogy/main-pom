package com.shigu.main4.cdn.vo;

import java.util.List;

/**
 * 楼层中的店铺
 * Created by Licca on 17/3/25.
 */
public class ShopInFloorVO {
    /**
     * 店铺ID
     */
    private Long id;
    /**
     * 档口号
     */
    private String num;

    /**
     * 新品标识 1为新品
     */
    private int isNew;
    /**
     * 标识
     */
    private String cate;
    /**
     * 退换服务，1退、2换
     */
    private List<Integer> tags;

    public String getCate() {
        return cate;
    }

    public void setCate(String cate) {
        this.cate = cate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public List<Integer> getTags() {
        return tags;
    }

    public void setTags(List<Integer> tags) {
        this.tags = tags;
    }

    public int getIsNew() {
        return isNew;
    }

    public void setIsNew(int isNew) {
        this.isNew = isNew;
    }
}
