package com.shigu.phone.basevo;

import com.openJar.beans.app.AppShopBlock;

import java.io.Serializable;
import java.util.List;

/**
 * Created By pc on 2017-10-17/18:14
 */
public class ShopSearchVO implements Serializable {
    //店铺数据
    private List<AppShopBlock> shops;
    //是否有下一页
    private Boolean hasNext;
    //总数
    private Integer total;

    public List<AppShopBlock> getShops() {
        return shops;
    }

    public void setShops(List<AppShopBlock> shops) {
        this.shops = shops;
    }

    public Boolean getHasNext() {
        return hasNext;
    }

    public void setHasNext(Boolean hasNext) {
        this.hasNext = hasNext;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
