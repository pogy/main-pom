package com.shigu.main4.item.services.utils;

import net.sf.json.JSONArray;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.Map;


/**
 * httpconn
 *
 */
public class HttpConnUtil {
    /**
     * =========================================================
     *
     * @param path
     * @方法名：selJson
     * @功能： Get方式加载JSONArr资源
     * @return:String =========================================================
     */
    public static JSONArray selJsonArrGet(String path) {
        Connection conn = getConn(path);
        try {
            String arrstr = conn.execute().body();//JSON数组的字符串形式
            try {
                JSONArray jsonarr = JSONArray.fromObject(arrstr);
                return jsonarr;
            } catch (Exception e) {
                return null;
            }
        } catch (IOException e) {
            return null;
        }
    }

    public static String selGet(String path) {
        Connection conn = getConn(path);
        try {
            String arrstr = conn.execute().body();//JSON数组的字符串形式
            if (arrstr != null && arrstr.trim().length() > 0) {
                return arrstr.trim();
            } else {
                return null;
            }
        } catch (IOException e) {
            return null;
        }
    }

    public static Connection getConnection(String url) {
        if (!StringUtils.isBlank(url) && !url.startsWith("http")) {//添加protocol，统一成http，宁愿他自己重定向
            url = "http://"+url.replace("//","");
        }
        Connection conn = Jsoup.connect(url);
        conn.followRedirects(false);
        conn.timeout(100000);
        return conn;
    }

    private static Connection getConn(String url) {
        if (!StringUtils.isBlank(url) && !url.startsWith("http")) {//添加protocol，统一成http，宁愿他自己重定向
            url = "http://"+url.replace("//","");
        }
        Connection conn = Jsoup.connect(url);
        conn.timeout(50000);
        return conn;
    }

    /**
     * =========================================================
     *
     * @param conn
     * @方法名：getCookie
     * @功能： 得到cookie
     * @return:Map<String,String> =========================================================
     */
    public static Map<String, String> getAllCookie(Connection conn) {
        Response response = null;
        try {
            response = conn.execute();
        } catch (IOException e) {
        }
        if (response != null) {
            return response.cookies();
        } else {

            return null;
        }
    }
}
