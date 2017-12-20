package com.shigu.tools;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * @类编号
 * @类名称：MD5Attestation
 * @文件路径：com.shigu.tools.MD5Attestation
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/10/30 15:00
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class MD5Attestation {
    private static final int _KEYTLENGTH = 6;

    /*public static void main(String[] args) {
        System.out.println(MD5Encode("2872276944"));
    }*/
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



    public static String MD5Encode(String origin) {
        com.openJar.commons.MD5Attestation md5 = new com.openJar.commons.MD5Attestation ();
        String[] _tmp = null;

        try {
            _tmp = md5.salt32(origin);
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        return _tmp[0];
    }
    /**
     * ====================================================================================
     * @方法名： signParam
     * @user gzy 2017/10/30 15:20
     * @功能：直接是参数进行加密
     * @param: [map]
     * @return: java.lang.String
     * @exception:
     * ====================================================================================
     *
     */
    public static String signParam(Map<String, Object> map) {

        Iterator<String> it = map.keySet().iterator();
        StringBuffer sb = new StringBuffer();
        ArrayList list = new ArrayList();

        while(it.hasNext()) {
            String key = (String)it.next();
            list.add(key);
        }

        Collections.sort(list);

        for(int i = 0; i < list.size(); ++i) {
            sb.append((String)list.get(i));
            sb.append(map.get(list.get(i)));
        }

        return MD5Encode(sb.toString());
    }
    /**
     * ====================================================================================
     * @方法名： signParamString
     * @user gzy 2017/10/30 15:19
     * @功能：url编码后再加密
     * @param: [map]
     * @return: java.lang.String
     * @exception:
     * ====================================================================================
     *
     */
    public static String signParamString(Map<String, String> map) {

        Iterator<String> it = map.keySet().iterator();
        StringBuffer sb = new StringBuffer();
        ArrayList list = new ArrayList();

        while(it.hasNext()) {
            String key = (String)it.next();
            list.add(key);
        }

        Collections.sort(list);//验签的顺序//用了一个集合的排序

        for(int i = 0; i < list.size(); ++i) {
            sb.append((String)list.get(i));

            try {
                sb.append(URLEncoder.encode((String)map.get(list.get(i)), "UTF-8"));
            } catch (UnsupportedEncodingException var6) {
                var6.printStackTrace();
            }
        }

        return MD5Encode(sb.toString());
    }

    public static boolean unsignParamString(Map<String, String> map, String code) {
        String checkcode = signParamString(map);
        return code.equals(checkcode);
    }

    public static boolean unsignParam(Map<String, Object> map, String code) {
        String checkcode = signParam(map);
        return code.equals(checkcode);
    }

    public MD5Attestation() {
    }

    private String getRandomKeyt(int length) throws Exception {
        if (length < 1) {
            throw new Exception("密钥长度不能小于 1");
        } else {
            String _keyt = "";

            for(int i = 0; i < length; ++i) {
                _keyt = _keyt + (char)(33 + (int)(Math.random() * 94.0D));
            }

            return _keyt;
        }
    }

    public String cell32(String plainText) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte[] b = md.digest();
            StringBuffer buf = new StringBuffer("");

            for(int offset = 0; offset < b.length; ++offset) {
                int i = b[offset];
                if (i < 0) {
                    i += 256;
                }

                if (i < 16) {
                    buf.append("0");
                }

                buf.append(Integer.toHexString(i));
            }

            return buf.toString();
        } catch (NoSuchAlgorithmException var7) {
            var7.printStackTrace();
            return null;
        }
    }

    public String[] salt32(String plainText) throws Exception {
        return this.salt("cell32", plainText);
    }

    public String cell16(String plainText) {
        String result = this.cell32(plainText);
        return result == null ? null : result.toString().substring(8, 24);
    }

    public String[] salt16(String plainText) throws Exception {
        return this.salt("cell16", plainText);
    }

    private String[] salt(String saltFunctionName, String plainText) throws Exception {
        String _keyt = "I1SWaG";
        return new String[]{(String)this.getClass().getMethod(saltFunctionName, Class.forName("java.lang.String")).invoke(this, this.cell32(plainText) + _keyt), _keyt};
    }
}

