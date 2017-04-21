package com.shigu.tools;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * 参数编码
 * Created by zhaohongbo on 17/3/16.
 */
public class EncodeParamter {
    /**
     * ios8859-1
     * @param param
     * @return
     */
    public static String iosToUtf8(String param){
        if(param==null){
            return null;
        }
        String[] escapeChar = {"%", "_"};
        try {
            param = new String(param.getBytes("ISO8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder(param);
        for (String c : escapeChar) {
            int i = sb.indexOf(c);
            if (i > -1)
                sb.insert(i, "\\");
        }
        return sb.toString();
    }

    /**
     * utf8解码字符
     * @param param
     * @return
     */
    public static String decodeUtf8(String param){
        if(param==null){
            return null;
        }
        try {
            param= URLDecoder.decode(param,"utf-8");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
        return param;
    }
}
