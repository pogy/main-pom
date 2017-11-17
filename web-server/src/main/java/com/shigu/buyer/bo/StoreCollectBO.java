package com.shigu.buyer.bo;

import java.io.Serializable;

/**
 * 店铺收藏
 * Created by zhaohongbo on 17/3/13.
 */
public class StoreCollectBO implements Serializable{

    /**
     * 分站标识
     */
    private String website;

    private Integer page;

    private Integer size=12;

    public Integer getPage() {
        if(page==null||page<1){
            return 1;
        }
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
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
}
