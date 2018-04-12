package com.shigu.goodsup.jd.util;

import com.openJar.requests.Request;
import com.openJar.responses.Response;
import com.shigu.goodsup.jd.exceptions.AuthOverException;
import com.shigu.goodsup.jd.exceptions.CustomException;
import com.shigu.tools.XzSdkClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class XzJdSdkSend {
    @Autowired
    private XzSdkClient xzSdkClient;

    public <T extends Request<O>,O extends Response> O send(T request) throws AuthOverException, CustomException {
        O res=xzSdkClient.getPcOpenClient().execute(request);
        if(res.isSuccess()){
            return res;
        }else{
            if("01".equals(res.getException().getCode())){
                throw new AuthOverException();
            }
            throw new CustomException(res.getException().getErrMsg());
        }

    }
}
