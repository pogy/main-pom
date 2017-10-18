package com.shigu.phone.waps.service;

import com.openJar.beans.app.AppSite;
import com.openJar.responses.app.SitesResponse;
import com.opentae.data.mall.beans.ShiguSite;
import com.opentae.data.mall.examples.ShiguSiteExample;
import com.opentae.data.mall.interfaces.ShiguSiteMapper;
import com.shigu.phone.baseservices.BaseStaticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WapStaticService {

    @Autowired
    private BaseStaticService baseStaticService;

    /**
     * 查询站点
     * @return
     */
    public  List<AppSite> selWebSites(){
        return baseStaticService.selWebSites();
    }

}
