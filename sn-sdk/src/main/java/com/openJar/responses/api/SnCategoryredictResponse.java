package com.openJar.responses.api;

import com.openJar.responses.Response;
import com.suning.api.entity.custom.CategoryredictGetResponse;

public class SnCategoryredictResponse extends Response {
    private CategoryredictGetResponse.GetCategoryredict getCategoryredict;

    public CategoryredictGetResponse.GetCategoryredict getGetCategoryredict() {
        return getCategoryredict;
    }

    public void setGetCategoryredict(CategoryredictGetResponse.GetCategoryredict getCategoryredict) {
        this.getCategoryredict = getCategoryredict;
    }
}
