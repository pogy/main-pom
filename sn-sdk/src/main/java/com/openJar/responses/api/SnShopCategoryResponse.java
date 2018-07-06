package com.openJar.responses.api;

import com.openJar.beans.SnShopCategory;
import com.openJar.responses.Response;
import com.suning.api.entity.shop.ShopcategoryQueryResponse;

import java.util.List;

public class SnShopCategoryResponse extends Response{
    private List<SnShopCategory> snShopCategories;

    public List<SnShopCategory> getSnShopCategories() {
        return snShopCategories;
    }

    public void setSnShopCategories(List<SnShopCategory> snShopCategories) {
        this.snShopCategories = snShopCategories;
    }
}
