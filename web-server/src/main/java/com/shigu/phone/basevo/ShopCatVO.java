package com.shigu.phone.basevo;

import com.openJar.beans.app.AppShopCat;

import java.io.Serializable;
import java.util.List;

/**
 * Created By pc on 2017-10-17/16:53
 */
public class ShopCatVO implements Serializable {
    //店内类目信息	必须
    private List<AppShopCat> cats;
    //商品总数
    private Long totalItemNum;

    public List<AppShopCat> getCats() {
        return cats;
    }

    public void setCats(List<AppShopCat> cats) {
        this.cats = cats;
    }

    public Long getTotalItemNum() {
        return totalItemNum;
    }

    public void setTotalItemNum(Long totalItemNum) {
        this.totalItemNum = totalItemNum;
    }
}
