package com.test.app;

import com.openJar.requests.app.CatRequest;
import com.openJar.requests.app.SitesRequest;
import com.openJar.responses.app.SitesResponse;
import com.openJar.tools.PcOpenClient;

public class ZFtest {
    public static void main(String[] args) {
        PcOpenClient c=new PcOpenClient("3838438", "37456A6A5CA10F9A988F12BFECD88575", "test");
//        SitesRequest req=new SitesRequest();
//        SitesResponse res=c.execute(req);
//        System.out.println(res.getBody());
        CatRequest catreq=new CatRequest();
        catreq.setType(1);
        catreq.setWebSite("hz");
        System.out.println(c.execute(catreq).getBody());


    }

}
