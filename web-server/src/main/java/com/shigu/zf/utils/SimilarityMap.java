package com.shigu.zf.utils;

import com.opentae.data.mall.beans.OrderCity;
import com.opentae.data.mall.beans.OrderProv;
import com.opentae.data.mall.beans.OrderTown;

import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

public class SimilarityMap<T> extends HashMap<String, T> {
    public T get(String key){
        return super.get(key);
    }

    public T get(String key, Long pid) {
        if (key == null) {
            return null;
        }
        if (pid == null) {
            if (this.size() > 0) {
                if (super.values().iterator().next() instanceof OrderProv) {
                    pid = 0L;
                } else {
                    pid = -1L;
                }
            } else {
                return null;
            }
        }
        T obj = super.get(pid + "," + key);
        if (obj != null) {
            return obj;
        }
        Long finalPid = pid;
        Set<String> keys = this.keySet().stream().filter(s -> s.startsWith(finalPid + ",")).collect(Collectors.toSet());
        double sxd = 0d;
        String isKey = "";
        for (String str : keys) {
            double d = SimilarityUtil.getSimilarityRatio(clean(str), clean(pid + "," + key));
            if (d > sxd) {
                sxd = d;
                isKey = str;
            }
        }
        return this.get(isKey);
    }
    /**
     * 区省市区脱裤
     * @param key
     * @return
     */
    private String clean(String key){
//        String[] flags={"省","市","州","地区","自治区","特别行政区","区","镇","县","乡"};
//        for(String flag:flags) {
//            if (key.endsWith(flag)) {
//                return key.substring(0, key.length() - flag.length());
//            }
//        }
        return key;
    }


    @Override
    public T put(String key, T obj) {
        if (obj == null) {
            return null;
        }
        String newKey = "-1";
        if (obj instanceof OrderProv) {
            newKey = "0";
        }
        if (obj instanceof OrderCity) {
            newKey = ((OrderCity) obj).getProvId() + "";
        }
        if (obj instanceof OrderTown) {
            newKey = ((OrderTown) obj).getCityId() + "";
        }
        newKey += "," + key;
        return super.put(newKey, obj);
    }



//	public T get(String key){
//		if(key==null){
//			return null;
//		}
//		T obj=super.get(key);
//		if(obj!=null){
//		    return obj;
//        }
//		String is_key="";
//		for(String str:this.keySet()){
//			String s1=clean(str);
//			String s2=clean(key);
//			if (s1.contains(s2)||s2.contains(s1)) {
//				is_key=str;
//				break;
//			}
//		}
//		return super.get(is_key);
//	}
//
//	/**
//	 * 区省市区脱裤
//	 * @param key
//	 * @return
//	 */
//	private String clean(String key){
//		String[] flags={"省","市","州","地区","自治区","特别行政区","区","镇"};
//		for(String flag:flags) {
//			if (key.endsWith(flag)) {
//				return key.substring(0, key.length() - flag.length());
//			}
//		}
//		return key;
//	}

}
