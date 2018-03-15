package com.shigu.phone.basevo;

import com.openJar.beans.app.AppGoodsBlock;

import java.io.Serializable;
import java.util.List;

/**
 * Created By pc on 2017-10-17/17:22
 */
public class ItemSearchVO implements Serializable {
    //商品数据
    private List<AppGoodsBlock> items;
    //是否还有下一页	必须
    private Boolean hasNext;
    //总条数
    private Integer total;

    public List<AppGoodsBlock> getItems() {
        return items;
    }

    public void setItems(List<AppGoodsBlock> items) {
        this.items = items;
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
