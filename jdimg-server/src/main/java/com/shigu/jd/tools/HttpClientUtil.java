package com.shigu.jd.tools;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

/**
 * Created By admin on 2017/12/18/11:25
 */
public class HttpClientUtil {

    public static HttpResponse excute(String url) throws IOException {
        HttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Accept-Charset","utf-8");
        return client.execute(httpPost);
    }

    public static HttpEntity excuteWithEntityRes(String url) throws IOException {
        HttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Accept-Charset","utf-8");
        return client.execute(httpPost).getEntity();
    }


}
