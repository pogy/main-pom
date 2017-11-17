package com.shigu.buyer.bo;

import java.io.Serializable;

/**
 * 商品收藏BO
 * Created by zhaohongbo on 17/3/13.
 */
public class GoodsCollectBO implements Serializable{
    /**
     * 分站标识
     */
    private String website;

    private String keyword;

    private Integer page;

    private Integer rows=12;

    /**
     *区分数据包和普通收藏
     * @return
     */
    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPage() {
        if(page==null||page<1){
            return 1;
        }
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
//        this.rows = rows;
    }

    public String getWebsite() {
        if(website==null){
            return "hz";
        }
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
