package com.openJar.responses.app;

import com.openJar.beans.AppShopBlock;
import com.openJar.responses.Response;

import java.util.List;

/**
 * 类名：ShopSearchResponse
 * 类路径：com.openJar.responses.app.ShopSearchResponse
 * 创建者：王浩翔
 * 创建时间：2017-08-29 12:22
 * 项目：main-pom
 * 描述：app端档口搜索响应结果
 */
public class ShopSearchResponse extends Response {
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
