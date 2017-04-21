package com.shigu.seller.bo;

import java.io.Serializable;

/**
 * 批量修改
 * Created by zhaohongbo on 17/3/19.
 */
public class MoreModifyBO implements Serializable{
    private Integer pageNo;

    private Integer pageSize=5;

    private Long goodsNumIid;


    public Integer getPageNo() {
        if(pageNo==null||pageNo<=0){
            pageNo=1;
        }
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo =pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = 5;
    }
}
