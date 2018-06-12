package com.shigu.sn.client;

import com.shigu.sn.api.util.JdKeyConfig;
import com.suning.api.DefaultSuningClient;
import com.suning.api.entity.fontorder.IsvorderQueryRequest;
import net.sf.json.JSONObject;

public class SnSdkClient {

    public JSONObject send(T request){
        DefaultSuningClient client = new DefaultSuningClient("",JdKeyConfig.snAppkey,JdKeyConfig.snSecret,"json");
        o res = client.excute(request);
        return res.getBody();
    }
}
