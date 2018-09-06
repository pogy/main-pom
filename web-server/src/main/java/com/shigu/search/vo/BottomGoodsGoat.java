package com.shigu.search.vo;

/**
 * 类名：BottomGoodsGoat
 * 类路径：com.shigu.search.vo.BottomGoodsGoat
 * 创建者：王浩翔
 * 创建时间：2017-08-09 16:58
 * 项目：main-pom
 * 描述：
 */
public class BottomGoodsGoat {

    private String id;

    private String imgSrc;

    private String piprice;

    private String storeId;

    private String fullStoreName;

    private String title;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getPiprice() {
        return piprice;
    }

    public void setPiprice(String piprice) {
        this.piprice = piprice;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getFullStoreName() {
        return fullStoreName;
    }

    public void setFullStoreName(String fullStoreName) {
        this.fullStoreName = fullStoreName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgSrc() {
        return this.imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }
}
