package com.shigu.main4.item.services.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class JsoupUtil {

    public synchronized static Document getHtml(String url) throws IOException {
        System.out.println(url);
        return getHtml(url,0);
    }
    public static Document getHtml(String url,int num) throws IOException {
        try {
            try {
                Thread.sleep(200L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return Jsoup.connect(url).timeout(60000).get();
        } catch (IOException e) {
            if(num<5){
                return getHtml(url,++num);
            }else{
                throw e;
            }
        }
    }
}