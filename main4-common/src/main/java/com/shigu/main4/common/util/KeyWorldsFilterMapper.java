package com.shigu.main4.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shigu.tools.KeyWordsUtil;

import java.util.*;

public class KeyWorldsFilterMapper {

    public static <T>List<T> toList(List<T> list){
        if(list==null||list.size()==0){
            return list;
        }
        Class c=list.get(0).getClass();
        return (List<T>)JSON.parseArray(KeyWordsUtil.duleKeyWords(JSON.toJSONString(list)),c);
    }
    public static <T>T[] toArray(T[] array){
        if(array==null||array.length==0){
            return array;
        }
        Class c=array[0].getClass();
        return (T[])JSON.parseArray(KeyWordsUtil.duleKeyWords(JSON.toJSONString(array)),c).toArray();
    }
    public static <T>Set<T> toSet(Set<T> set){
        if(set==null||set.size()==0){
            return null;
        }
        return new HashSet<>(toList(new ArrayList<>(set)));
    }
    public static <T>Map<Object,T> toMap(Map<Object,T> map){
        if(map==null||map.size()==0){
            return map;
        }
        for(Object key:map.keySet()){
            map.put(key,toObject(key,map.get(key)));
        }
        return map;
    }

    public static <T>T toObject(Object key,T obj){
        if(obj==null){
            return null;
        }
        if(obj instanceof String&&("title".equals(key)||((String) obj).contains("desc"))){
            return (T)KeyWordsUtil.duleKeyWords(obj.toString());
        }
        if(obj instanceof List){
            return (T)toList((List)obj);
        }
        if(obj instanceof Set){
            return (T)toSet((Set)obj);
        }
        if(obj.getClass().isArray()){
            return (T)toArray((Object[])obj);
        }
        if(obj instanceof Map){
            return (T)toMap((Map)obj);
        }
        JSONObject json;
        try {
            json=JSON.parseObject(JSON.toJSONString(obj));
        } catch (Exception e) {
            //不能转成json的,说明的单个值,直接跳出
            return obj;
        }
        return (T) toObject(null,json);
    }

    public static void main(String[] args) {
        JSONObject obj=JSON.parseObject("{'1':1}");
        System.out.println(toObject(null,obj));
    }
}
