package com.shigu.tools;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import java.util.*;

public class KeyWordsUtil {
    //最
    static String veryKey = "最先进加工工艺,最先进科学,史上最低价,最新科学,最新技术,最先享受,最受欢迎,最大程度,最优秀,最先进,最舒适,最时尚,最奢侈,最流行,最聚拢,最高级,最高端,最符合,最低价,最低级,最便宜,最赚,最优,最具,最佳,最好,最高,最底,最低,最大,最爱";
    // 一
    static String oneKeyWords = "中国第一,全网第一,销量第一,排名第一,第一品牌,独一无二,全国第一";
    //  首/家/国
    static String FHKKeyWords = "填补国内空白,全国销量冠军,国家领导人,国家级产品,中国驰名,全网首家,全国首家,全网首发,全国首发,国家免检,国际品质,独家配方,首家,首个,国家";
    //时间
    static String timeKeyWords = "随时结束,随时涨价,马上降价,驰名商标";
    //级/极
    static String extraKeyWords = "国家级产品,顶级享受,顶级工艺,宇宙级,世界级,全球级,国家级,终极,绝佳,绝对,尖端,极致,极品,极佳,高级,顶尖,顶级";
    //        品牌
    static String brandKeyWords = "世界领先,领袖品牌,领先上市,创领品牌,掌门人,缔造者,著名,至尊,之王,王牌,奢侈,名牌,领袖,巨星,金牌,冠军,巅峰";
    //        虚假
    static String shamKeyWords = "史无前例,前无古人,纯天然,祖传,永久,无敌,精确,超赚,100%";
    //        权威
    static String authorityKeyWords = "无需国家质量检测,错过就没机会了,中国驰名商标,再不抢就没了,不会再便宜了,专家推荐,万人疯抢,全民抢购,全民疯抢,抢疯了,卖疯了,免抽检,老字号,专供,特供,抢爆,秒杀";


    private static final List<String> veryKeyList ;

    private static final List<String> FHKKeyList;

    private static final List<String> timeKeyList;

    private static final List<String> extraKeyList;

    private static final List<String> brandKeyList;

    private static final List<String> oneKeyList;

    private static final List<String> shamKeyList;

    private static final List<String> authorityKeyList;

    private static final List<String> allKeys;

    static {
        veryKeyList = Arrays.asList(veryKey.split(","));
        oneKeyList = Arrays.asList(oneKeyWords.split(","));
        FHKKeyList = Arrays.asList(FHKKeyWords.split(","));
        timeKeyList = Arrays.asList(timeKeyWords.split(","));
        extraKeyList = Arrays.asList(extraKeyWords.split(","));
        brandKeyList = Arrays.asList(brandKeyWords.split(","));
        shamKeyList = Arrays.asList(shamKeyWords.split(","));
        authorityKeyList = Arrays.asList(authorityKeyWords.split(","));

        allKeys=new ArrayList<>();
        allKeys.addAll(veryKeyList);
        allKeys.addAll(oneKeyList);
        allKeys.addAll(FHKKeyList);
        allKeys.addAll(timeKeyList);
        allKeys.addAll(extraKeyList);
        allKeys.addAll(brandKeyList);
        allKeys.addAll(shamKeyList);
        allKeys.addAll(authorityKeyList);
        Collections.sort(allKeys,new KeySort());
    }

//    public static boolean verifyKeyWords(String orignalWords) {
//        for (int i = 0; i < veryKeyList.size(); i++) {
//            String value = veryKeyList.get(i);
//            if(value.indexOf(orignalWords)>=0){
//                return true;
//            }
//        }
//        for (int i = 0; i < oneKeyList.size(); i++) {
//            String value = oneKeyList.get(i);
//            if(value.indexOf(orignalWords)>=0){
//                return true;
//            }
//        }
//        for (int i = 0; i < FHKKeyList.size(); i++) {
//            String value = FHKKeyList.get(i);
//            if(value.indexOf(orignalWords)>=0){
//                return true;
//            }
//        }
//        for (int i = 0; i < timeKeyList.size(); i++) {
//            String value = timeKeyList.get(i);
//            if(value.indexOf(orignalWords)>=0){
//                return true;
//            }
//        }
//        for (int i = 0; i < extraKeyList.size(); i++) {
//            String value = extraKeyList.get(i);
//            if(value.indexOf(orignalWords)>=0){
//                return true;
//            }
//        }
//        for (int i = 0; i < brandKeyList.size(); i++) {
//            String value = brandKeyList.get(i);
//            if(value.indexOf(orignalWords)>=0){
//                return true;
//            }
//        }
//        for (int i = 0; i < shamKeyList.size(); i++) {
//            String value = shamKeyList.get(i);
//            if(value.indexOf(orignalWords)>=0){
//                return true;
//            }
//        }
//        for (int i = 0; i < authorityKeyList.size(); i++) {
//            String value = authorityKeyList.get(i);
//            if(value.indexOf(orignalWords)>=0){
//                return true;
//            }
//        }
//        return  false;
//    }

    /**
     * 替换语句中所有关键词
     * @param orignalWords
     * @param keyWordsList
     * @return
     */
    private static String duleKeyWordsInList(String orignalWords, List<String> keyWordsList) {
        if(StringUtils.isEmpty(orignalWords)){
            return orignalWords;
        }
        for (String value : keyWordsList) {
            if (orignalWords.contains(value)) {
                orignalWords = orignalWords.replaceAll(value, "");
            }
        }
        return orignalWords;
    }

    /**
     * 处理关键词
     * @param orignalWords
     * @return
     */
    public static String duleKeyWords(String orignalWords) {
//        orignalWords = duleKeyWordsInList(orignalWords,veryKeyList);
//        orignalWords = duleKeyWordsInList(orignalWords,FHKKeyList);
//        orignalWords = duleKeyWordsInList(orignalWords,timeKeyList);
//        orignalWords = duleKeyWordsInList(orignalWords,extraKeyList);
//        orignalWords = duleKeyWordsInList(orignalWords,brandKeyList);
//        orignalWords = duleKeyWordsInList(orignalWords,shamKeyList);
//        orignalWords = duleKeyWordsInList(orignalWords,authorityKeyList);
//        orignalWords = duleKeyWordsInList(orignalWords,oneKeyList);

        return duleKeyWordsInList(orignalWords,allKeys);
    }

    public static void main(String[] args) {
        System.out.println(duleKeyWords("100%"));
    }

    static class KeySort implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            return o2.toString().length()-o1.toString().length();
        }
    }
}
