package com.shigu.tools;

import java.util.HashMap;
import java.util.Map;

/**
 * @类编号
 * @类名称：TestMap
 * @文件路径：com.shigu.tools.TestMap
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/10/30 15:02
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class TestMap {

    public static void main(String args[]){

        Map<String, String> map=new HashMap<> ();
        String skey="skey";
        map.put ("skey",skey);
        String aset="aset";
        map.put ("aset",aset);

        map.put ("abcd","a1");

        map.put("desc","b1");
        map.put("ser","wq1");

       String signs= MD5Attestation.signParamString (map);
        System.out.println ("signs="+signs);

        Map<String, String> map1=new HashMap<> ();
        String skey1="skey";

        String aset1="aset";
        map1.put("ser","wq1");
        map1.put ("aset",aset1);

        map1.put("desc","b1");

        map1.put ("skey",skey1);
        map1.put ("abcd","a1");


       boolean flag= MD5Attestation.unsignParamString (map1,signs);
       System.out.println ("flag="+flag);
    }
}
