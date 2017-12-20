package com.shigu.tools;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * @类编号
 * @类名称：Test
 * @文件路径：com.shigu.tools.Test
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/10/23 11:09
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class Test {



    public static String url = "http://client.movek.net:8888/sms.aspx";
    public static String userid = "1323";
    public static String account = "SDK-A1323-1323";
    public static String password = "13231323";
    public static String checkWord = "这个字符串中是否包含了屏蔽字";

    public static void main(String[] args) throws IOException {
        String content="测试短信";
        //keyword();
        // overage();
       // SmsClientInterface.sendSms ( url,  userid,  account, password, "18857193391",content );
        test();
    }

    public static void keyword() {

        String keyword = SmsClientKeyword.queryKeyWord(url, userid, account,password, checkWord);
        System.out.println(keyword);
    }

    public static void overage() {

        String overage = SmsClientOverage.queryOverage(url, userid, account,password);
        System.out.println(overage);
    }

    public static void test() throws IOException {
        //String send = SmsClientAccessTool.getInstance().doAccessHTTPPost("http://118.145.30.35/sms.aspx", "", "utf-8");
        //http://client.movek.net:8888/sms.aspx?action=send&userid=特服号&account=序列号&password=密码&mobile=手机号1,手机号2,手机号N&content=您的验证码是：ABCD【签名】
        String mobile="18857193391,17605818805";
        Document doc = Jsoup.connect("http://client.movek.net:8888/sms.aspx")
                .data("action", "send")
                .data ("userid",userid)
                .data ("account",account)
                .data ("password",password)
                .data ("mobile",mobile)
                .data ("content","您的验证码是559988【四季星座网】")
                //.userAgent("Mozilla")
               // .cookie("auth", "token")
                .timeout(3000)
                .post();

        System.out.println(doc.html ());
    }
}
