package com.shigu.seller.bo;

/**
 * 发布淘宝宝贝
 * Created by zhaohongbo on 17/3/4.
 */
public class SendTbItemBO extends GhsGet{
    private Integer pageNo;

    private Integer pageSize=10;

    public Integer getPageNo() {
        if(pageNo==null||pageNo<=0){
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

    public void setPageSize(Integer pageSize) {
        this.pageSize = 10;
    }
}
