package com.openJar.responses.api;

import com.openJar.responses.Response;
import com.suning.api.entity.integrate.itemContentsAddResponse;
import com.suning.api.entity.item.ApplyParams;
import com.suning.api.entity.item.ItemAddResponse;

public class SnItemAddResponse extends Response{
    private ApplyParams applyParams;
    private String errmsg;

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public ApplyParams getApplyParams() {
        return applyParams;
    }

    public void setApplyParams(ApplyParams applyParams) {
        this.applyParams = applyParams;
    }
}
