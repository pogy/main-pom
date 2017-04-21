package com.shigu.seller.bo;

import java.io.Serializable;

/**
 * 添加区域
 * Created by zhaohongbo on 17/4/18.
 */
public class AddAreaBO implements Serializable{
    /**
     * 位置类别
     */
    private Integer type;
    /**
     * 相邻边
     */
    private Long side;
    /**
     * 2前1后
     */
    private Integer after;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getSide() {
        return side;
    }

    public void setSide(Long side) {
        this.side = side;
    }

    public Integer getAfter() {
        return after;
    }

    public void setAfter(Integer after) {
        this.after = after;
    }
}
