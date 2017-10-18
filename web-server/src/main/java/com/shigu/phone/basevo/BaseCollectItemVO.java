package com.shigu.phone.basevo;

import com.openJar.beans.app.AppGoodsBlock;

import java.io.Serializable;
import java.util.List;

/**
 * Created By pc on 2017-10-17/16:41
 */
public class BaseCollectItemVO implements Serializable {
    //是否有下一页
    private Boolean hasNext;
    //商品数据
    private List<AppGoodsBlock> items;
    //总条数
    private Integer total;

    public Boolean getHasNext() {
        return hasNext;
    }

    public void setHasNext(Boolean hasNext) {
        this.hasNext = hasNext;
    }

    public List<AppGoodsBlock> getItems() {
        return items;
    }

    public void setItems(List<AppGoodsBlock> items) {
        this.items = items;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
