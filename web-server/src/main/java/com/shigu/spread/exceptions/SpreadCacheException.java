package com.shigu.spread.exceptions;

import com.shigu.main4.common.exceptions.Main4Exception;

/**
 * Created by zhaohongbo on 17/4/10.
 */
public class SpreadCacheException extends Main4Exception{

    private CacheType type;
    /**
     * 值
     */
    private Object obj;

    public SpreadCacheException() {
    }

    public SpreadCacheException(String message) {
        super(message);
    }

    public CacheType getType() {
        return type;
    }

    public void setType(CacheType type) {
        this.type = type;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
    /**
     * 0短缓存有,1长缓存有,2都没有
     */
    public enum CacheType{
        SHORT(0),LONG(1),NONE(2);

        CacheType(int value) {
            this.value = value;
        }

        private int value;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
