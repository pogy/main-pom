package com.openJar.responses.api;

import com.openJar.responses.Response;
import com.suning.api.entity.integrate.itemContentsAddResponse;
import com.suning.api.entity.item.ApplyParams;
import com.suning.api.entity.item.ItemAddResponse;

public class SnItemAddResponse extends Response{
    private ApplyParams applyParams;

    public ApplyParams getApplyParams() {
        return applyParams;
    }

    public void setApplyParams(ApplyParams applyParams) {
        this.applyParams = applyParams;
    }
}
