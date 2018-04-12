package com.shigu.goodsup.jd.vo;

import com.taobao.api.domain.SellerCat;

import java.util.List;

/**
 * 店内类目
 * Created by zhaohongbo on 17/1/17.
 */
public class StoreCatVO {

    public StoreCatVO() {
    }

    public StoreCatVO(SellerCat cat) {
        this.catId = cat.getCid();
        this.name=cat.getName();
    }

    /**
     * 店内类目ID
     */
    private Long catId;
    /**
     * 类目名
     */
    private String name;
    /**
     * 子集类目
     */
    private List<StoreCatVO> subCat;

    public Long getCatId() {
        return catId;
    }

    public void setCatId(Long catId) {
        this.catId = catId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StoreCatVO> getSubCat() {
        return subCat;
    }

    public void setSubCat(List<StoreCatVO> subCat) {
        this.subCat = subCat;
    }
}
