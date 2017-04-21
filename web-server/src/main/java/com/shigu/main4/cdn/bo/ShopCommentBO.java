package com.shigu.main4.cdn.bo;

import java.io.Serializable;

/**
 * 店铺讨论区BO
 * Created by zhaohongbo on 17/3/8.
 */
public class ShopCommentBO implements Serializable{
    /**
     * 店铺ID
     */
    private Long id;

    private Integer pageNo;

    private Integer pageSize=10;

    public Integer getPageNo() {
        if(pageNo==null||pageNo<1){
            pageNo=1;
        }
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
