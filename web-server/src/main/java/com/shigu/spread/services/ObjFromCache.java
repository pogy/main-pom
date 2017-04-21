package com.shigu.spread.services;


import com.shigu.spread.exceptions.SpreadCacheException;

/**
 * 二次缓存抽象
 * Created by zhaohongbo on 17/4/10.
 */
public abstract class ObjFromCache<T>{

    /**
     * 默认以short为准
     */
    private SpreadCacheException.CacheType type= SpreadCacheException.CacheType.SHORT;

    EhCacheForIndexPage ehCacheForIndexPage;

    String key;

    Class tclass;

    public ObjFromCache(EhCacheForIndexPage ehCacheForIndexPage, String key, Class tclass) {
        this.ehCacheForIndexPage = ehCacheForIndexPage;
        this.key = key;
        this.tclass = tclass;
    }

    /**
     * 真查询
     * @return
     */
    public abstract T selReal();

    /**
     * 查询逻辑
     * @return
     */
    public T selObj(){
        T obj;
        try {
            obj= (T) ehCacheForIndexPage.getFromCache(key,tclass);
            return obj;
        } catch (SpreadCacheException e) {
            type=e.getType();
            if(type.equals(SpreadCacheException.CacheType.NONE)){
                obj=selReal();
                ehCacheForIndexPage.putCache(key,obj);
                return obj;
            }else if(type.equals(SpreadCacheException.CacheType.LONG)){
                return (T) e.getObj();
            }
        }
        return null;
    }

    public SpreadCacheException.CacheType getType() {
        return type;
    }

    public void setType(SpreadCacheException.CacheType type) {
        this.type = type;
    }
}
