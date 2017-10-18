package com.shigu.phone.basevo;

import com.openJar.beans.app.AppShopBlock;

import java.io.Serializable;
import java.util.List;

/**
 * Created By pc on 2017-10-17/18:20
 */
public class StoreCollectVO implements Serializable {

    //总条数
    private Integer total;
    //是否有下一页
    private Boolean hasNext;
    //商品数据
    private List<AppShopBlock> shops;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Boolean getHasNext() {
        return hasNext;
    }

    public void setHasNext(Boolean hasNext) {
        this.hasNext = hasNext;
    }

    public List<AppShopBlock> getShops() {
        return shops;
    }

    public void setShops(List<AppShopBlock> shops) {
        this.shops = shops;
    }
}
