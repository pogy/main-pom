package com.shigu.zf.utils;

import java.util.HashMap;

public class SimilarityMap<T> extends HashMap<String, T>{
	public T get(String key){
		if(key==null){
			return null;
		}
		double sxd=0d;
		String is_key="";
		for(String str:this.keySet()){
			double d=SimilarityUtil.sim(str, key);
			if(d>sxd){
				sxd=d;
				is_key=str;
			}
		}
		return super.get(is_key);
	}
}
