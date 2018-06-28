package com.openJar.responses.api;

import com.openJar.responses.Response;
import com.suning.api.entity.shop.ShopcategoryQueryResponse;

import java.util.List;

public class SnShopCategoryResponse extends Response{
    private List<ShopcategoryQueryResponse.ShopCategory> shopCategories;

    public List<ShopcategoryQueryResponse.ShopCategory> getShopCategories() {
        return shopCategories;
    }

    public void setShopCategories(List<ShopcategoryQueryResponse.ShopCategory> shopCategories) {
        this.shopCategories = shopCategories;
    }
}
