package com.openJar.responses.app;

import com.openJar.beans.AppGoodsBlock;
import com.openJar.responses.Response;

import java.util.List;

/**
 * 类名：ImgSearchResponse
 * 类路径：com.openJar.responses.app.ImgSearchResponse
 * 创建者：王浩翔
 * 创建时间：2017-08-29 13:26
 * 项目：main-pom
 * 描述：app端图搜响应
 */
public class ImgSearchResponse extends Response {
    //匹配的商品数据
    private List<AppGoodsBlock> items;

    public List<AppGoodsBlock> getItems() {
        return items;
    }

    public void setItems(List<AppGoodsBlock> items) {
        this.items = items;
    }
}
