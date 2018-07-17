package com.openJar.responses.api;

import com.openJar.responses.Response;
import com.suning.api.entity.item.ItemparametersQueryResponse;

import java.util.List;

public class SnItemParametersResponse extends Response{
    private List<ItemparametersQueryResponse.ItemparametersQuery> itemparametersQueries;

    public List<ItemparametersQueryResponse.ItemparametersQuery> getItemparametersQueries() {
        return itemparametersQueries;
    }

    public void setItemparametersQueries(List<ItemparametersQueryResponse.ItemparametersQuery> itemparametersQueries) {
        this.itemparametersQueries = itemparametersQueries;
    }
}
