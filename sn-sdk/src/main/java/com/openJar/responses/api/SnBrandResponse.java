package com.openJar.responses.api;

import com.openJar.responses.Response;
import com.suning.api.entity.custom.NewbrandQueryResponse;

import java.util.List;

public class SnBrandResponse extends Response {
    private List<NewbrandQueryResponse.QueryNewbrand> queryNewbrand;

    public List<NewbrandQueryResponse.QueryNewbrand> getQueryNewbrand() {
        return queryNewbrand;
    }

    public void setQueryNewbrand(List<NewbrandQueryResponse.QueryNewbrand> queryNewbrand) {
        this.queryNewbrand = queryNewbrand;
    }
}
