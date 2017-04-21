package com.shigu.main4.cdn.vo;

/**
 * 市场页面,上方标签
 * Created by zhaohongbo on 17/3/25.
 */
public class MarketTagVO {
    /**
     * 市场ID
     */
    private Long id;
    /**
     * 市场名称
     */
    private String name;

    public MarketTagVO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
