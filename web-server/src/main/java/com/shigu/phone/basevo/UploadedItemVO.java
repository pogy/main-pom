package com.shigu.phone.basevo;

import com.openJar.beans.app.AppItemUploaded;

import java.io.Serializable;
import java.util.List;

/**
 * Created By pc on 2017-10-17/18:02
 */
public class UploadedItemVO implements Serializable {
    //是否有下一页	必须
    private Boolean hasNext;
    //总条数	必须
    private Integer total;
    //宝贝信息	必须
    private List<AppItemUploaded> items;

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

    public List<AppItemUploaded> getItems() {
        return items;
    }

    public void setItems(List<AppItemUploaded> items) {
        this.items = items;
    }
}
