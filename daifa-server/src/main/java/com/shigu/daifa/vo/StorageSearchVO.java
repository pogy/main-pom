package com.shigu.daifa.vo;

import com.shigu.main4.common.tools.ShiguPager;

import java.util.List;

public class StorageSearchVO {
    private Integer num;
    private String price;
    private ShiguPager<DaifaStockRecordVO> pager;

    public Integer getNum() {
        return this.num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public ShiguPager<DaifaStockRecordVO> getPager() {
        return this.pager;
    }

    public void setPager(ShiguPager<DaifaStockRecordVO> pager) {
        this.pager = pager;
    }
}
