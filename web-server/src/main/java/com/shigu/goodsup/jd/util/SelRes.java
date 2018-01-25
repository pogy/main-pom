package com.shigu.goodsup.jd.util;

import com.openJar.requests.Request;
import com.openJar.responses.Response;
import com.openJar.tools.OpenClient;
import com.openJar.tools.PcOpenClient;

public class SelRes<T extends Request<O>,O extends Response>{
    public O selResponse(T req){
        OpenClient client=new PcOpenClient("3838438","37456A6A5CA10F9A988F12BFECD88575","test");
        return client.execute(req);
    }
}
