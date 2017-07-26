package com.shigu.main4.newcdn.vo;

import java.util.List;

/**
 * Created by zf on 2017/7/25.
 */
public class CdnShopCatVO {
    /**
     * 店内类目ID
     */
    private Long cid;
    /**
     * 店内类目名
     */
    private String name;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 子类目
     */
    private List<CdnShopCatVO> subCats;

    /**
     * 获取 店内类目ID
     */
    public Long getCid() {
        return this.cid;
    }

    /**
     * 设置 店内类目ID
     */
    public void setCid(Long cid) {
        this.cid = cid;
    }

    /**
     * 获取 店内类目名
     */
    public String getName() {
        return this.name;
    }

    /**
     * 设置 店内类目名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取 排序
     */
    public Integer getSort() {
        return this.sort;
    }

    /**
     * 设置 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取 子类目
     */
    public List<CdnShopCatVO> getSubCats() {
        return this.subCats;
    }

    /**
     * 设置 子类目
     */
    public void setSubCats(List<CdnShopCatVO> subCats) {
        this.subCats = subCats;
    }
}
