package com.shigu.main4.newcdn.vo;

/**
 * Created by zf on 2017/7/25.
 */
public class CdnCollectShopVO {
    /**
     * 档口ID
     */
    private Long id;
    /**
     * 市场名加档口号
     */
    private String name;

    /**
     * 获取 档口ID
     */
    public Long getId() {
        return this.id;
    }

    /**
     * 设置 档口ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 市场名加档口号
     */
    public String getName() {
        return this.name;
    }

    /**
     * 设置 市场名加档口号
     */
    public void setName(String name) {
        this.name = name;
    }
}
