package com.openJar.responses.api;

import com.openJar.responses.Response;
import com.suning.api.entity.item.CategoryQueryResponse;

import java.util.List;

public class SnCategoryResponse extends Response {
    private List<CategoryQueryResponse.CategoryQuery> categoryQueryList;

    private String cname;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    private String totalSize;

    public String getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(String totalSize) {
        this.totalSize = totalSize;
    }

    public List<CategoryQueryResponse.CategoryQuery> getCategoryQueryList() {
        return categoryQueryList;
    }

    public void setCategoryQueryList(List<CategoryQueryResponse.CategoryQuery> categoryQueryList) {
        this.categoryQueryList = categoryQueryList;
    }
}
