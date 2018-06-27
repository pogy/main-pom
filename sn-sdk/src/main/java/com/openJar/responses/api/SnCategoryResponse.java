package com.openJar.responses.api;

import com.openJar.responses.Response;
import com.suning.api.entity.item.CategoryQueryResponse;

import java.util.List;

public class SnCategoryResponse extends Response {
    private List<CategoryQueryResponse.CategoryQuery> categoryQueryList;

    public List<CategoryQueryResponse.CategoryQuery> getCategoryQueryList() {
        return categoryQueryList;
    }

    public void setCategoryQueryList(List<CategoryQueryResponse.CategoryQuery> categoryQueryList) {
        this.categoryQueryList = categoryQueryList;
    }
}
