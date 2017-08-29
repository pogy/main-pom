package com.openJar.responses.app;

import com.openJar.beans.AppGoodsBlock;
import com.openJar.responses.Response;

import java.util.List;

/**
 * 类名：ItemSearchResponse
 * 类路径：com.openJar.responses.app.ItemSearchResponse
 * 创建者：王浩翔
 * 创建时间：2017-08-29 13:10
 * 项目：main-pom
 * 描述：app端商品搜索响应
 */
public class ItemSearchResponse extends Response {
    //商品数据
    private List<AppGoodsBlock> items;
    //是否还有下一页
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
