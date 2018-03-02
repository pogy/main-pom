package com.openJar.responses.api;

import com.openJar.beans.SdkJdShopCategory;
import com.openJar.responses.Response;

import java.util.List;

/**
 * Created By admin on 2017/12/14/15:58
 */
public class JdShopCategoryResponse extends Response {

    private List<SdkJdShopCategory> jdShopCategories;

    public List<SdkJdShopCategory> getJdShopCategories() {
        return jdShopCategories;
    }

    public void setJdShopCategories(List<SdkJdShopCategory> jdShopCategories) {
        this.jdShopCategories = jdShopCategories;
    }
}
