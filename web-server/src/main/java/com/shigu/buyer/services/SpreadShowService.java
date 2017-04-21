package com.shigu.buyer.services;

import com.shigu.services.DubboAllService;
import com.shigu.spread.exceptions.SpreadReadException;
import com.shigu.spread.services.SelSpreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 广告内容加载服务
 * Created by zhaohongbo on 17/2/27.
 */
@Service
public class SpreadShowService {
    @Autowired
    DubboAllService dubboAllService;

    @Autowired
    protected EhCacheCacheManager spreadcacheManager;

    /**
     * 带缓存的查出广告
     * @param tags
     * @return
     * @throws SpreadReadException
     */
    public Map<String,String> selByTags(String... tags) throws SpreadReadException {
        Cache cache=spreadcacheManager.getCache("spreadShowCache");
        String key="";
        for(String t:tags){
            key+=t+",";
        }
        if(cache.get(key)!=null){
            return (Map<String,String>) cache.get(key).get();
        }
        SelSpreadService selSpreadService=dubboAllService.getSelSpreadService();
        if(selSpreadService==null){
            throw new SpreadReadException("selSpreadService 为null,dubbo链接不上");
        }
        Map<String,String> map=selSpreadService.selByTags(tags);
        cache.put(key,map);
        return map;
    }

}
