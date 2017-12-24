package com.shigu.util;


import com.shigu.exceptions.ImgDownloadException;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by zhaohongbo on 17/5/22.
 */
public class DownImage {
    private static final Logger logger = LoggerFactory.getLogger(DownImage.class);

    public static void main(String[] args) throws ImgDownloadException {
        System.out.println(downImgFile("https://img.alicdn.com/imgextra/i2/105348211/TB237rop1J8puFjy1XbXXagqVXa_!!105348211.jpg"));
    }
    /**
     * 纯粹的下载
     * 1、验证可下载性
     * 2、下载图片
     * @param sourceUrl
     * @return
     */
    public static byte[] downImgFile(String sourceUrl) throws ImgDownloadException {
        if(StringUtils.isEmpty(sourceUrl)){
            throw new ImgDownloadException("sourceUrl is null");
        }
        try {
            HttpURLConnection connection=getHttpURLConnectionByUrl(sourceUrl);
            connection.setConnectTimeout(10000);
            connection.setReadTimeout(1000);
            int code=connection.getResponseCode();
            try {
                if(code>=400){//网络资源不存在
                    throw new ImgDownloadException("图片下载失败");
                }else{
                    Connection conn= Jsoup.connect(sourceUrl);
                    conn.followRedirects(false);
                    conn.timeout(30000);//100000//100可行
                    Connection.Response res=conn.execute();
                    if(res.header("Location")!=null){
                        return downImgFile(res.header("Location"));
                    }else{
//                        if(res.header("Content-Type").contains("image")){
                        //这里成功了,上传Oss,有效时长定个
                        return res.bodyAsBytes();
//                        }
                    }
                }
            } finally {
                connection.disconnect();
            }
        } catch (Exception e) {
            //记一下日志
            logger.error("down img error",e);
        }
        throw new ImgDownloadException("图片下载失败");
    }

    /**
     * 获取一个url的HttpURLConnection
     */
    private static HttpURLConnection getHttpURLConnectionByUrl(String sURL)  throws IOException
    {
        URL url = new URL(sURL);
        HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
        httpConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.0 Safari/537.36");
        return httpConnection;
    }
}
