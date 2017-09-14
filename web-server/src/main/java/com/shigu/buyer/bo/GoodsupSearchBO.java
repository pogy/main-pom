package com.shigu.buyer.bo;

import java.io.Serializable;
import java.util.Date;

/**
 * 类名：GoodsupSearchBO
 * 类路径：com.shigu.buyer.bo.GoodsupSearchBO
 * 创建者：王浩翔
 * 创建时间：2017-09-13 14:58
 * 项目：main-pom
 * 描述：已上传的商品搜索条件，前端确定字段后需要进行修改
 */
public class GoodsupSearchBO implements Serializable {
    //当前页
    private Integer number;
    //每页数量
    private Integer size;
    //档口已下架
    private Boolean shopSoldoutIs;
    //淘宝已下架
    private Boolean tbOnSoldoutIs;
    //搜索上架时间段起始时间
    private Date gt;
    //搜索上架时间段结束时间
    private Date et;

    public Integer getNumber() {
        if (number == null || number < 1) {
            return 1;
        }
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getSize() {
        if (size == null || size < 1) {
            return 12;
        }
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Boolean getShopSoldoutIs() {
        return shopSoldoutIs;
    }

    public void setShopSoldoutIs(Boolean shopSoldoutIs) {
        this.shopSoldoutIs = shopSoldoutIs;
    }

    public Boolean getTbOnSoldoutIs() {
        return tbOnSoldoutIs;
    }

    public void setTbOnSoldoutIs(Boolean tbOnSoldoutIs) {
        this.tbOnSoldoutIs = tbOnSoldoutIs;
    }

    public Date getGt() {
        return gt;
    }

    public void setGt(Date gt) {
        this.gt = gt;
    }

    public Date getEt() {
        return et;
    }

    public void setEt(Date et) {
        this.et = et;
    }
}
