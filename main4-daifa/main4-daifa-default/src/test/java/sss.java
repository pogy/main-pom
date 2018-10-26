import net.sf.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class sss {
    public static void main(String[] args) throws IOException {
        JSONObject obj = new JSONObject();
        obj.put("partner_id", "1");
        obj.put("shopid", "1");
        obj.put("timestamp", "1");
        Connection connect = Jsoup.connect("https://partner.uat.shopeemobile.com/api/v1/item/categories/get")
                .validateTLSCertificates(false).ignoreContentType(true);
        connect.requestBody(obj.toString());
        connect.method(Connection.Method.POST);
        connect.header("Host", "http://upload.571xz.com");
        connect.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:62.0) Gecko/20100101 Firefox/62.0");
        connect.header("Accept", "application/json, text/javascript, */*; q=0.01");
        connect.header("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
        connect.header("Connection", "keep-alive");

        System.out.println(connect.execute().body());
        ;
    }
}
