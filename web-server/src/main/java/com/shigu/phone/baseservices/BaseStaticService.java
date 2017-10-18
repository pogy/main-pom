package com.shigu.phone.baseservices;

import com.openJar.beans.app.AppSite;
import com.opentae.data.mall.beans.ShiguSite;
import com.opentae.data.mall.examples.ShiguSiteExample;
import com.opentae.data.mall.interfaces.ShiguSiteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BaseStaticService {
    @Autowired
    ShiguSiteMapper shiguSiteMapper;
    @Autowired
    EhCacheCacheManager ehCacheManager;

    /**
     * 查询站点
     * @return
     */
    public List<AppSite> selWebSites(){
        Cache cache=ehCacheManager.getCache("appWebSite");
        List<AppSite> sites=cache.get("appWebSite",List.class);
        if(sites==null||sites.size()==0){
            ShiguSiteExample shiguSiteExample=new ShiguSiteExample();
            shiguSiteExample.createCriteria().andRemark1EqualTo("1");
            shiguSiteExample.setOrderByClause("sort_order asc");
            List<ShiguSite> shiguSites=shiguSiteMapper.selectByExample(shiguSiteExample);
            sites=new ArrayList<>();
            for(ShiguSite s:shiguSites){
                if("xh".equals(s.getCitySite())||"jf".equals(s.getCitySite())){
                    continue;
                }
                AppSite s1=new AppSite();
                s1.setSiteName(s.getCityName());
                s1.setWebSite(s.getCitySite());
                sites.add(s1);
            }
            cache.put("appWebSite",sites);
        }
        return sites;
    }
}
