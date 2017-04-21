package com.shigu.main4.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 店内宝贝,按类目的聚合
 * Created by zhaohongbo on 17/2/16.
 */
public class CatPolymerization implements Serializable{

    private static final long serialVersionUID = -21942058544162165L;
    /**
     * 类目名称
     */
    private String name;
    /**
     * 类目ID
     */
    private Long cid;
    /**
     * 聚合所得数
     */
    private Long number;
    /**
     * 子级类目聚合情况,有这个说明自己是父级
     */
    private List<CatPolymerization> subPolymerizations;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public List<CatPolymerization> getSubPolymerizations() {
        return subPolymerizations;
    }

    public void setSubPolymerizations(List<CatPolymerization> subPolymerizations) {
        this.subPolymerizations = subPolymerizations;
    }
}
