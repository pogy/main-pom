package com.shigu.goodsup.jd.service;

import com.openJar.tools.OpenClient;
import com.openJar.tools.PcOpenClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created By admin on 2017/12/24/12:38
 */
@Service
public class OpenClientService {

    @Value("${xz_appkey}")
    private String OPEN_CLIENT_APPKEY;

    @Value("${xz_secret}")
    private String OPEN_CLIENT_SECRET;

    @Value("${xz_type}")
    private String OPEN_CLIENT_SERVERTYPE;

    public OpenClient getOpenClient (){
        return new PcOpenClient(OPEN_CLIENT_APPKEY, OPEN_CLIENT_SECRET,
                OPEN_CLIENT_SERVERTYPE);
    }
}
