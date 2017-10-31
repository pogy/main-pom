package com.shigu.phone.apps.utils;

import com.shigu.api.exceptions.SystemException;
import com.shigu.main4.tools.RedisIO;
import com.utils.publics.Opt3Des;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;

import java.util.Date;

public class TokenUtil {
    public static String parse(String token){
        token=token.replace(" ", "+");
        return Opt3Des.decryptPlainData(token);
    }

    public static String format(Long userId){
        Long time=new Date().getTime();
        String str=time+","+userId;
        return Opt3Des.encryptPlainData(str);
    }

    public static Long parseUserId(String token, RedisIO redisIO) throws SystemException {
        if (StringUtils.isEmpty(token)) {
            SystemException e = new SystemException();
            e.setMsg("登录过期");
            throw e;
        }
        String str = TokenUtil.parse(token);
        if (StringUtils.isEmpty(str)) {
            SystemException e = new SystemException();
            e.setMsg("登录过期");
            throw e;
        }
        Long userId;
        try {
            userId = new Long(str.split(",")[1]);
        } catch (Exception ignored) {
            SystemException e = new SystemException();
            e.setMsg("登录过期");
            throw e;
        }
        String otoken = redisIO.get("phone_login_token" + userId);
        if (otoken == null) {
            SystemException e = new SystemException();
            e.setMsg("登录过期");
            throw e;
        }
        String[] oldTokenStrs = otoken.split("@@@@@---@@@@@");
        String oldToken = oldTokenStrs[0];
        if (oldToken == null || !token.equals(oldToken)) {
            SystemException e = new SystemException();
            e.setMsg("登录过期");
            throw e;
        }
        Long time = new Long(oldTokenStrs[1]);
        Long time2 = new Date().getTime();
        if (time2 - time > 600000L) {
            String uuid = oldToken + "@@@@@---@@@@@" + time2;
            Jedis jedis = redisIO.getJedis();
            jedis.setex("phone_login_token" + userId, 604800, uuid);
        }
        return userId;
    }
}
