package com.shigu.tools;

import com.utils.publics.Opt3Des;
import net.sf.json.JSONObject;

/**
 * @类编号
 * @类名称：TestEncryptDencrypt
 * @文件路径：com.shigu.tools.TestEncryptDencrypt
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/10/30 13:55
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class TestEncryptDencrypt {

    public static void main(String args[]){

        JSONObject json = new JSONObject();
        json.put("userName", "test25");
        json.put("userId", "25");
        json.put("email","gubest_1@126.com");
        String p = json.toString();
        p= Opt3Des.encryptPlainData(p);//加密
        System.out.println(p);

        String jiemi=Opt3Des.decryptPlainData (p);//解密
        System.out.println(jiemi);
    }
}
