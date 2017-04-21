package com.shigu.component.shiro;

import com.shigu.main4.ucenter.services.UserBaseService;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.crypto.hash.Sha384Hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 公有密码验证器
 * Created by zhaohongbo on 17/2/15.
 */
public class ShiguCredentialsMatcher extends SimpleCredentialsMatcher {

    private UserBaseService userBaseService;

    public UserBaseService getUserBaseService() {
        return userBaseService;
    }

    public void setUserBaseService(UserBaseService userBaseService) {
        this.userBaseService = userBaseService;
    }

    public String encrypt(String data) {
//        String sha384Hex = new Sha384Hash(data).toBase64();
        if(data != null && data.length() != 0) {
            StringBuffer hexString = new StringBuffer();

            try {
                MessageDigest e = MessageDigest.getInstance("MD5");
                e.update(data.getBytes());
                byte[] hash = e.digest();

                for(int i = 0; i < hash.length; ++i) {
                    if((255 & hash[i]) < 16) {
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
}
