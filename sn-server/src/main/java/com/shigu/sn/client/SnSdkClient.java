package com.shigu.sn.client;

import com.shigu.sn.api.util.SnKeyConfig;
import com.suning.api.DefaultSuningClient;
import com.suning.api.SuningRequest;
import com.suning.api.SuningResponse;
import com.suning.api.exception.SuningApiException;

public class SnSdkClient {

    private static final String test_url ="https://openpre.cnsuning.com/api/http/sopRequest";

    private static final String rest_url ="https://open.suning.com/api/http/sopRequest";

    public <T extends SuningRequest<O>,O extends SuningResponse> O send(T request) throws SuningApiException{
        DefaultSuningClient client = new DefaultSuningClient(test_url, SnKeyConfig.snAppkey, SnKeyConfig.snSecret,"json");
        return client.excute(request);
    }
}
