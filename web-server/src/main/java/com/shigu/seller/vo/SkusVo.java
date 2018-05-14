package com.shigu.seller.vo;

import java.io.Serializable;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.seller.vo
 * @ClassName: SkusVo
 * @Author: sy
 * @CreateDate: 2018/5/4 0004 16:24
 */
public class SkusVo implements Serializable {

    private String color;
    private String size;
    private Integer num;
    private Integer haveTakeGoodsNum;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getHaveTakeGoodsNum() {
        return haveTakeGoodsNum;
    }

    public void setHaveTakeGoodsNum(Integer haveTakeGoodsNum) {
        this.haveTakeGoodsNum = haveTakeGoodsNum;
    }
}
