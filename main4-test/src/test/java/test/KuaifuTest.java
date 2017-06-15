package test;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.junit.Test;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaohongbo on 17/6/9.
 */
public class KuaifuTest {
    private String rest="https://kfshopapi.51youdian.com/gateway";
    private String app_id="20170511105707694028";
    private String secret="3218087ab1f440b6ab9fda206de41e41";

    @Test
    public void createTest() throws IOException {
        Map<String,String> map=new HashMap<>();
        map.put("app_id",app_id);
        map.put("content","{\"merchant_id\":\"20170517194339011844\",\"total_amount\":0.01}");
        map.put("method","fshows.kfshop.openapi.wx.qrcode");
        map.put("version","1.0");

        StringBuilder signMsg= new StringBuilder();
        signMsg.append("app_id="+map.get("app_id"));
        signMsg.append("&content="+map.get("content"));
        signMsg.append("&method="+map.get("method"));
        signMsg.append("&version="+map.get("version"));
        signMsg.append("&key="+secret);
        map.put("sign",getMD5(signMsg.toString()));
        Connection conn=Jsoup.connect(rest);
        conn.ignoreContentType(true);
        conn.data(map);
        System.out.println(conn.post());
    }

    public static String getMD5(String str) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            return "";
        }
    }
}
