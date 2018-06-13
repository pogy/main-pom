package com.shigu.spread.services;

import com.shigu.spread.exceptions.SpreadCacheException;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.spread.services
 * @ClassName: ObjFormFlickrRedis
 * @Author: sy
 * @CreateDate: 2018/5/6 0006 9:02
 */
public abstract class ObjFormFlickrRedis<T> {

    /**
     * 默认以short为准
     */
    private SpreadCacheException.CacheType type= SpreadCacheException.CacheType.SHORT;

    RedisForFlickrPage redisForFlickrPage;

    String key;

    Class tclass;

    public ObjFormFlickrRedis(RedisForFlickrPage redisForFlickrPage, String key, Class tclass) {
        this.redisForFlickrPage = redisForFlickrPage;
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
            obj= (T) redisForFlickrPage.getFromCache(key,tclass);
            return obj;
        } catch (SpreadCacheException e) {
//            type=e.getType();
//            if(type.equals(SpreadCacheException.CacheType.NONE)){
            obj=selReal();
            redisForFlickrPage.putCache(key,obj);
            return obj;
//            }else if(type.equals(SpreadCacheException.CacheType.LONG)){
//                return (T) e.getObj();
//            }
        }
    }

    public SpreadCacheException.CacheType getType() {
        return type;
    }

    public void setType(SpreadCacheException.CacheType type) {
        this.type = type;
    }

}
