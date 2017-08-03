package com.shigu.main4.ucenter.util;

import net.sf.json.JSONArray;
import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.Map;

/**
 * ==========================================================
 * TODO
 *
 * @类编号：
 * @类名称：HttpConnUtil.java
 * @文件路径：com.shigu.common.utils.HttpConnUtil.java
 * @内容摘要：
 * @编码作者：赵洪波
 * @完成日期：
 * @Date2014-5-30下午4:30:44
 * @comments: =========================================================
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
//			System.out.println(conn.execute().body());
//			Document dom=conn.get();

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
//			System.out.println(conn.execute().body());
//			Document dom=conn.get();

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
        Connection conn = Jsoup.connect(url);
        conn.followRedirects(false);
        conn.timeout(100000);
        return conn;
    }

    private static Connection getConn(String url) {
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
