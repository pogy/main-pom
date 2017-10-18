package com.shigu.phone.apps.services;

import com.openJar.beans.app.AppSite;
import com.openJar.responses.app.SitesResponse;
import com.shigu.phone.baseservices.BaseStaticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppStaticService {
    @Autowired
    private BaseStaticService baseStaticService;

    /**
     * 查询站点
     * @return
     */
    public SitesResponse selWebSites(){
        List<AppSite> appSites = baseStaticService.selWebSites();
        SitesResponse response=new SitesResponse();
        response.setSites(appSites);
        response.setSuccess(true);
        return response;
    }
}
