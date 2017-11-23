package com.shigu.phone.apps.utils;

import com.shigu.api.exceptions.SystemException;
import com.shigu.main4.tools.RedisIO;
import com.utils.publics.Opt3Des;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;

import java.util.Date;

public class TokenUtil {
    public static String parse(String token){
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
            e.setErrMsg("登录过期");
            throw e;
        }
//        token=token.replace(" ", "+");
        token = hexStr2Str(token);
        String str = parse(token);
        if (StringUtils.isEmpty(str)) {
            SystemException e = new SystemException();
            e.setErrMsg("登录过期");
            throw e;
        }
        Long userId;
        try {
            userId = new Long(str.split(",")[1]);
        } catch (Exception ignored) {
            SystemException e = new SystemException();
            e.setErrMsg("登录过期");
            throw e;
        }
        String otoken = redisIO.get("phone_login_token" + userId);
        if (otoken == null) {
            SystemException e = new SystemException();
            e.setErrMsg("登录过期");
            throw e;
        }
        String[] oldTokenStrs = otoken.split("@@@@@---@@@@@");
        String oldToken = oldTokenStrs[0];
        if (oldToken == null || !token.equals(oldToken)) {
            SystemException e = new SystemException();
            e.setErrMsg("登录过期");
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

    /**
     * 字符串转换成为16进制(无需Unicode编码)
     * @param str
     * @return
     */
    public static String str2HexStr(String str) {
        char[] chars = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder("");
        byte[] bs = str.getBytes();
        int bit;
        for (int i = 0; i < bs.length; i++) {
            bit = (bs[i] & 0x0f0) >> 4;
            sb.append(chars[bit]);
            bit = bs[i] & 0x0f;
            sb.append(chars[bit]);
            // sb.append(' ');
        }
        return sb.toString().trim();
    }

    /**
     * 16进制直接转换成为字符串(无需Unicode解码)
     * @param hexStr
     * @return
     */
    public static String hexStr2Str(String hexStr) {
        String str = "0123456789ABCDEF";
        char[] hexs = hexStr.toCharArray();
        byte[] bytes = new byte[hexStr.length() / 2];
        int n;
        for (int i = 0; i < bytes.length; i++) {
            n = str.indexOf(hexs[2 * i]) * 16;
            n += str.indexOf(hexs[2 * i + 1]);
            bytes[i] = (byte) (n & 0xff);
        }
        return new String(bytes);
    }

}
