package com.shigu.main4.common.exceptions;

import java.util.HashMap;
import java.util.Map;

/**
 * json请求异常
 * Created by Licca on 17/2/28.
 */
public class JsonErrException extends Main4Exception{
    private Map<String,Object> errorMap;
    public JsonErrException() {
    }

    /**
     * 添加其它错误元素
     * @param ename
     * @param obj
     * @return
     */
    public JsonErrException addErrMap(String ename,Object obj){
        if(errorMap==null){
            errorMap=new HashMap<>();
        }
        errorMap.put(ename,obj);
        return this;
    }

    public Map<String, Object> getErrorMap() {
        return errorMap;
    }

    public JsonErrException(String message) {
        super(message);
    }
}
