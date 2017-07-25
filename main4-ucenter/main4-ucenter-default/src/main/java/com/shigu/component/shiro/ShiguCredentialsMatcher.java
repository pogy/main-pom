package com.shigu.component.shiro;

import com.shigu.component.encrypt.EncryptUtil;
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
}
