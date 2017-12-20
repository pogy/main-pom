package com.shigu.zf.utils;

import java.util.HashMap;

public class SimilarityMap<T> extends HashMap<String, T>{
	public T get(String key){
		if(key==null){
			return null;
		}
		String is_key="";
		for(String str:this.keySet()){
			String s1=clean(str);
			String s2=clean(key);
			if (s1.contains(s2)||s2.contains(s1)) {
				is_key=str;
				break;
			}
		}
		return super.get(is_key);
	}

	/**
	 * 区省市区脱裤
	 * @param key
	 * @return
	 */
	private String clean(String key){
		String[] flags={"省","市","州","地区","自治区","特别行政区","区","镇"};
		for(String flag:flags) {
			if (key.endsWith(flag)) {
				return key.substring(0, key.length() - flag.length());
			}
		}
		return key;
	}
}
