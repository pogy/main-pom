package com.shigu.main4.ucenter.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class EncryptUtil {

    /**
     * 加密
     * @param data
     * @return
     */
//    public static String encrypt(String data) {
//        String sha384Hex = new Sha384Hash(data).toBase64();
//        if (data != null && data.length() != 0) {
//            StringBuffer hexString = new StringBuffer();
//            try {
//                MessageDigest e = MessageDigest.getInstance("MD5");
//                e.update(data.getBytes());
//                byte[] hash = e.digest();
//
//                for (int i = 0; i < hash.length; ++i) {
//                    if ((255 & hash[i]) < 16) {
//                        hexString.append("0" + Integer.toHexString(255 & hash[i]));
//                    } else {
//                        hexString.append(Integer.toHexString(255 & hash[i]));
//                    }
//                }
//            } catch (NoSuchAlgorithmException var5) {
//                throw new RuntimeException("" + var5);
//            }
//            return hexString.toString();
//        } else {
//            throw new IllegalArgumentException("String to encript cannot be null or zero length");
//        }
//    }

    public static String encrypt(String data) {
        if(data != null && data.length() != 0) {
            return md5(data).toString();
        } else {
            throw new IllegalArgumentException("String to encript cannot be null or zero length");
        }
    }

    public static String encrypt(String data,String data1) {
        if(data != null && data.length() != 0&&data1!=null &&data1.length()!=0) {
            return md5(data).append(md5(data1)).toString();
        } else {
            throw new IllegalArgumentException("String to encript cannot be null or zero length");
        }
    }

    private static StringBuilder md5(String data){
        StringBuilder hexString = new StringBuilder();
        try {
            MessageDigest e = MessageDigest.getInstance("MD5");
            e.update(data.getBytes());
            for (byte aHash : e.digest()) {
                if ((255 & aHash) < 16) {
                    hexString.append("0").append(Integer.toHexString(255 & aHash));
                } else {
                    hexString.append(Integer.toHexString(255 & aHash));
                }
            }
        } catch (NoSuchAlgorithmException var5) {
            throw new RuntimeException(var5);
        }
        return hexString;
    }
    /**
     * 随机密码
     * @return
     */
    public static String genRandomPwd(int count){
        int  maxNum = 36;
        int i;
        if(count == 0){
            count = 8;
        }
        char[] str = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
                'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
                'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        StringBuffer pwd = new StringBuffer("");
        Random r = new Random();
        while(count > 0){
            i = Math.abs(r.nextInt(maxNum));
            if (i >= 0 && i < str.length) {
                pwd.append(str[i]);
                count --;
            }
        }
        return pwd.toString();
    }

    public static void main(String args[]) {
        String pwd =  encrypt("123456");
        //System.out.print(pwd);
    }

}
