package com.shigu.sn.client;

import com.shigu.sn.api.util.SnKeyConfig;
import com.suning.api.DefaultSuningClient;
import com.suning.api.SuningMultiPartRequest;
import com.suning.api.SuningRequest;
import com.suning.api.SuningResponse;
import com.suning.api.exception.SuningApiException;
import org.springframework.stereotype.Service;

@Service
public class SnSdkClient {

    private static final String rest_url = "https://open.suning.com/api/http/sopRequest";

    public <T extends SuningRequest<O>, O extends SuningResponse> O send(T request, String accessToken) throws SuningApiException {
        DefaultSuningClient client = new DefaultSuningClient(rest_url, SnKeyConfig.snAppkey, SnKeyConfig.snSecret, accessToken, "json");
        return client.excute(request);
    }

    public <T extends SuningRequest<O>, O extends SuningResponse> O testSend(T request, String snAppkey, String snSecret,String accessToken) throws SuningApiException {
        DefaultSuningClient client = new DefaultSuningClient(rest_url, snAppkey, snSecret,accessToken, "json");
        return client.excute(request);
    }

    public <T extends SuningMultiPartRequest<O>, O extends SuningResponse> O mulSend(T request,String accessToken) throws SuningApiException {
        DefaultSuningClient client = new DefaultSuningClient(rest_url, SnKeyConfig.snAppkey, SnKeyConfig.snSecret,accessToken, "json");
        return client.excuteMultiPart(request);
    }
}
