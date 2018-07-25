package com.shigu.buyer.vo;


import com.shigu.main4.packages.bo.PackageItem;

import java.io.Serializable;

/**
 * 数据包中商品
 * Created by zhaohongbo on 17/3/13.
 */
public class PackageItemVO implements Serializable{
    /**
     * 商品ID
     */
    private Long id;
    /**
     * 商品标题
     */
    private String title;
    /**
     * 商品首图
     */
    private String imgsrc;

    public PackageItemVO(PackageItem item) {
        setId(item.getId());
        setTitle(item.getTitle());
        setImgsrc(item.getPicUrl());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }
}
