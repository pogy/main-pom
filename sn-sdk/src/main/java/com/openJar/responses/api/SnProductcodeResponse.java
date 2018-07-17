package com.openJar.responses.api;

import com.openJar.responses.Response;
import com.suning.api.entity.custom.GetproductcodeQueryResponse;

public class SnProductcodeResponse extends Response{

    private GetproductcodeQueryResponse.ResultData resultData;

    public GetproductcodeQueryResponse.ResultData getResultData() {
        return resultData;
    }

    public void setResultData(GetproductcodeQueryResponse.ResultData resultData) {
        this.resultData = resultData;
    }
}
