package com.openJar.responses.api;

import com.openJar.responses.Response;
import com.suning.api.entity.custom.NewbrandQueryResponse;

public class SnBrandResponse extends Response {
    private NewbrandQueryResponse.QueryNewbrand queryNewbrand;

    public NewbrandQueryResponse.QueryNewbrand getQueryNewbrand() {
        return queryNewbrand;
    }

    public void setQueryNewbrand(NewbrandQueryResponse.QueryNewbrand queryNewbrand) {
        this.queryNewbrand = queryNewbrand;
    }
}
