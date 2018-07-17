package com.openJar.responses.api;

import com.openJar.responses.Response;
import com.suning.api.entity.sale.FreighttemplateQueryResponse;

import java.util.List;

public class SnFreightTemplateResponse extends Response{
    private List<FreighttemplateQueryResponse.QueryFreighttemplate> queryFreighttemplateList;

    public List<FreighttemplateQueryResponse.QueryFreighttemplate> getQueryFreighttemplateList() {
        return queryFreighttemplateList;
    }

    public void setQueryFreighttemplateList(List<FreighttemplateQueryResponse.QueryFreighttemplate> queryFreighttemplateList) {
        this.queryFreighttemplateList = queryFreighttemplateList;
    }
}
