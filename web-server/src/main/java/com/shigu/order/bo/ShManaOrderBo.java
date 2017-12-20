package com.shigu.order.bo;

/**
 * Created by zf on 2017/7/24.
 */
public class ShManaOrderBo {
    private Integer shStatus;
    private Integer page;
    private Integer size = 10;

    public Integer getShStatus() {
        return this.shStatus;
    }

    public void setShStatus(Integer shStatus) {
        this.shStatus = shStatus;
    }

    public Integer getPage() {
        return this.page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
