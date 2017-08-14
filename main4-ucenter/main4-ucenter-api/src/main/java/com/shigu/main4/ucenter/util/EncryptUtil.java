package com.shigu.main4.ucenter.util;


import org.apache.shiro.crypto.hash.Sha384Hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class EncryptUtil {

    /**
     * 加密
     * @param data
     * @return
     */
    public static String encrypt(String data) {
        String sha384Hex = new Sha384Hash(data).toBase64();
        if (data != null && data.length() != 0) {
            StringBuffer hexString = new StringBuffer();
            try {
                MessageDigest e = MessageDigest.getInstance("MD5");
                e.update(data.getBytes());
                byte[] hash = e.digest();

                for (int i = 0; i < hash.length; ++i) {
                    if ((255 & hash[i]) < 16) {
                        hexString.append("0" + Integer.toHexString(255 & hash[i]));
                    } else {
                        hexString.append(Integer.toHexString(255 & hash[i]));
                    }
                }
            } catch (NoSuchAlgorithmException var5) {
                throw new RuntimeException("" + var5);
            }
            return hexString.toString();
        } else {
            throw new IllegalArgumentException("String to encript cannot be null or zero length");
        }
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
        System.out.print(pwd);
    }

}
